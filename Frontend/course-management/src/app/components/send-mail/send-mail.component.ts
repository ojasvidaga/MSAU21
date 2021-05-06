import { Component, Inject, OnInit, Optional } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { SessionStorageService } from 'angular-web-storage';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FileService } from '../../providers/files/file.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Course } from 'src/app/models/course/Course';
import { TrainingService } from '../../providers/training/training.service';

@Component({
  selector: 'app-send-mail',
  templateUrl: './send-mail.component.html',
  styleUrls: ['./send-mail.component.scss']
})
export class SendMailComponent implements OnInit {

  trainerId = this.session.get('user').empId;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  constructor(
    public session: SessionStorageService,
    private snackBar: MatSnackBar,
    private fileService: FileService,
    public dialogRef: MatDialogRef<SendMailComponent>,
    public trainingService: TrainingService,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: Course
  ) { }

  ngOnInit() {
    this.dialogRef.updateSize('30%', '50%');
  }

  sendMail() {
    const emailId = this.emailFormControl.value;
    this.trainingService.sendMail(this.data, this.trainerId, emailId).subscribe((response) => {
      console.log(response);
      this.dialogRef.close();
      this.openSnackBar('Mail Sent Successfully', 'Done');
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }


}
