import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { SessionStorageService } from 'angular-web-storage';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FileService } from '../../providers/files/file.service';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.scss']
})

export class UploadFileComponent implements OnInit {

  trainerId = this.session.get('user').empId;
  files: any = [];

  constructor(
    public session: SessionStorageService,
    private snackBar: MatSnackBar,
    private fileService: FileService,
    public dialogRef: MatDialogRef<UploadFileComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: number) {

  }

  ngOnInit() {
    this.dialogRef.updateSize('80%', '80%');
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  uploadFile(event) {
    for (const index of event) {
      this.files.push(index);
    }
  }

  deleteAttachment(index) {
    this.files.splice(index, 1);
  }

  sendFilesToDB() {
    this.fileService.addTrainingMaterial(this.files, this.data, this.trainerId).subscribe((response) => {
      console.log(response);
      this.openSnackBar('File Added Successfully', 'Done!');
      this.files = [];
    });
    this.dialogRef.close();
  }


  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}
