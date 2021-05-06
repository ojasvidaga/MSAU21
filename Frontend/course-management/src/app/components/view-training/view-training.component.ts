import { Component, OnInit, Inject, Optional, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { SessionStorageService } from 'angular-web-storage';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FileService } from '../../providers/files/file.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TrainingService } from '../../providers/training/training.service';
import { User } from 'src/app/models/login/user';
import { Material } from 'src/app/models/training/Material';


@Component({
  selector: 'app-view-training',
  templateUrl: './view-training.component.html',
  styleUrls: ['./view-training.component.scss']
})
export class ViewTrainingComponent implements OnInit {

  unprocessedFiles: Material[] = [];
  trainers: User[];
  courseId: number;

  constructor(
    public session: SessionStorageService,
    private snackBar: MatSnackBar,
    private fileService: FileService,
    public dialogRef: MatDialogRef<ViewTrainingComponent>,
    public trainingService: TrainingService,
    @Optional() @Inject(MAT_DIALOG_DATA) public data) {

    this.trainers = data.trainers;
    this.courseId = data.courseId;

    for (const trainer of this.trainers) {
      this.fileService.getTrainingMaterial(this.courseId, trainer.empId).subscribe((response: Material[]) => {
        if (response !== []) {
          for (const obj of response) {
            this.unprocessedFiles.push(obj);
          }
          console.log('Received BLOB in All ->', this.unprocessedFiles);
        }

      });
    }

  }

  ngOnInit() {
    this.dialogRef.updateSize('80%', '80%');
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  base64ToArrayBuffer(base64) {
    const binaryString = window.atob(base64);
    const len = binaryString.length;
    const bytes = new Uint8Array(len);

    for (let i = 0; i < len; i++) {
      bytes[i] = binaryString.charCodeAt(i);
    }

    return bytes.buffer;
  }

  downloadFile(data, fileType) {
    const byteArray = this.base64ToArrayBuffer(data);
    const blob = new Blob([byteArray], { type: fileType });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}
