import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Course } from 'src/app/models/course/Course';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UploadFileComponent } from '../upload-file/upload-file.component';
import { ViewDeleteFileComponent } from '../view-delete-file/view-delete-file.component';
import { SocialloginService } from '../../providers/login/sociallogin.service';
import { SendMailComponent } from '../send-mail/send-mail.component';
import { ManageCourseService } from '../../providers/manage-courses/manage-course.service';

@Component({
  selector: 'app-my-courses',
  templateUrl: './my-courses.component.html',
  styleUrls: ['./my-courses.component.scss']
})

export class MyCoursesComponent implements OnInit {

  trainerId: number;
  courses: Course[] = [];

  constructor(
    public session: SessionStorageService,
    public loginService: SocialloginService,
    public service: ManageCourseService,
    public router: Router,
    public http: HttpClient,
    private snackBar: MatSnackBar,
    public dialog: MatDialog) {

  }

  ngOnInit() {
    if (!this.loginService.getLoginStatus()) {
      alert('You are not logged in !!!');
      this.router.navigate(['/login']);
    } else {
      this.trainerId = this.session.get('user').empId;

      this.service.getAllCoursesForCurrentTrainer(this.trainerId).subscribe((response: Course[]) => {
        this.courses = response;
        console.log(this.courses);
      });
    }
  }

  openAddDialog(id) {

    this.dialog.open(UploadFileComponent, {
      data: {
        courseId: id
      }
    },
    );
  }

  openDeleteDialog(id) {

    this.dialog.open(ViewDeleteFileComponent, {
      data: {
        courseId: id
      }
    },
    );
  }

  openMailDialog(course) {
    this.dialog.open(SendMailComponent, {
      data: course
    },
    );
  }

}
