import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { SessionStorageService } from 'angular-web-storage';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FileService } from '../../providers/files/file.service';
import { Material } from 'src/app/models/training/Material';

@Component({
  selector: 'app-view-delete-file',
  templateUrl: './view-delete-file.component.html',
  styleUrls: ['./view-delete-file.component.scss']
})
export class ViewDeleteFileComponent implements OnInit {

  trainerId = this.session.get('user').empId;
  unprocessedFiles = [];
  cId: number;

  constructor(
    public session: SessionStorageService,
    private snackBar: MatSnackBar,
    private fileService: FileService,
    public dialogRef: MatDialogRef<ViewDeleteFileComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data) {
    this.cId = data.courseId;
  }

  ngOnInit() {
    this.dialogRef.updateSize('30%', '50%');
    this.fileService.getTrainingMaterial(this.cId, this.trainerId).subscribe((response: Material[]) => {
      this.unprocessedFiles = response;
      console.log('Received BLOB ->', this.unprocessedFiles);
    });
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

  deleteTraining(fileId) {
    console.log(fileId);
    if (confirm('You Sure want to delete the Training Material?')) {
      this.fileService.deleteTraining(fileId).subscribe((response) => {
        console.log(response);
        this.ngOnInit();
      });
    }
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}
