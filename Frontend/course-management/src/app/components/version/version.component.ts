
import { Component, OnInit, Inject, Optional, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FileVersions } from 'src/app/models/course/FileVersions';


@Component({
  selector: 'app-version',
  templateUrl: './version.component.html',
  styleUrls: ['./version.component.scss']
})
export class VersionComponent implements OnInit {

  versions: FileVersions[];

  constructor(
    private snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<VersionComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data) {
    this.versions = data.versions;
    console.log('Inside Dialog', this.versions);
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
