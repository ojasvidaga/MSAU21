import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { Course } from 'src/app/models/course/Course';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { User } from 'src/app/models/login/user';
import { Training } from 'src/app/models/training/Training';
import { SocialloginService } from '../../providers/login/sociallogin.service';
import { ManageCourseService } from '../../providers/manage-courses/manage-course.service';

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.scss']
})
export class ManageCoursesComponent implements OnInit {

  // Mat Table
  displayedColumns: string[] = ['id', 'name', 'location', 'prerequisites', 'skills', 'addTrainerActions', 'editActions', 'deleteActions'];
  dataSource: MatTableDataSource<Course>;

  // Form Variables
  addCourseForm: FormGroup;
  editCourseForm: FormGroup;
  modifyCourseId: number;

  // Screen Control
  editMode = false;
  trainerMode = false;

  // DOM Manipulations
  section = 'Add Course';
  sections: string[] = ['Add Course', 'Modify/Delete Course'];
  COURSE_DATA: Course[] = [];
  trainers: User[] = [];
  trainerCourse: number;
  allEmployees: User[] = [];

  // Auto Complete
  myControl = new FormControl();
  options: string[];
  filteredOptions: Observable<string[]>;

  // Mat Component Interaction Variables
  // @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  // @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(
    public formBuilder: FormBuilder,
    public session: SessionStorageService,
    public loginService: SocialloginService,
    public service: ManageCourseService,
    public router: Router,
    private snackBar: MatSnackBar) {

    this.addCourseForm = new FormGroup({
      name: new FormControl('', Validators.required),
      location: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      prerequisites: new FormControl('', Validators.required),
      skills: new FormControl('', Validators.required),
    });

    this.editCourseForm = new FormGroup({
      editName: new FormControl('', Validators.required),
      editLocation: new FormControl('', Validators.required),
      editDescription: new FormControl('', Validators.required),
      editPrerequisites: new FormControl('', Validators.required),
      editSkills: new FormControl('', Validators.required),
    });
  }

  ngOnInit() {
    if (!this.loginService.getLoginStatus()) {
      alert('You are not logged in !!!');
      this.router.navigate(['/login']);
    } else {
      this.service.getAllCourses().subscribe((response: Course[]) => {
        console.log(response);
        this.COURSE_DATA = response;
        this.dataSource = new MatTableDataSource(this.COURSE_DATA);
        // this.dataSource.paginator = this.paginator;
        // this.dataSource.sort = this.sort;
      });
    }
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 4000,
    });
  }

  addCourse() {
    const obj = new Course();

    obj.courseName = this.addCourseForm.value.name;
    obj.courseLocation = this.addCourseForm.value.location;
    obj.courseDescription = this.addCourseForm.value.description;
    obj.courseSkills = this.addCourseForm.value.skills;
    obj.coursePrerequisites = this.addCourseForm.value.prerequisites;
    obj.courseAdminId = this.session.get('user').empId;

    this.service.addCourse(obj).subscribe((response) => {
      console.log(response);
      this.openSnackBar('Course Added Successfully', 'Done');
      window.location.reload();
    });
  }

  editCourse() {
    const obj = new Course();

    obj.courseId = this.modifyCourseId;
    obj.courseName = this.editCourseForm.value.editName;
    obj.courseLocation = this.editCourseForm.value.editLocation;
    obj.courseDescription = this.editCourseForm.value.editDescription;
    obj.courseSkills = this.editCourseForm.value.editSkills;
    obj.coursePrerequisites = this.editCourseForm.value.editPrerequisites;
    obj.courseAdminId = this.session.get('user').empId;

    console.log(obj);
    this.service.editCourse(obj).subscribe((response) => {
      console.log(response);
      this.openSnackBar('Course Updated Successfully', 'Done');
      this.goBack();
    });

    this.modifyCourseId = null;
  }

  addEditTrainerScreen(course: Course) {
    this.trainerMode = true;
    this.editMode = true;
    this.trainerCourse = course.courseId;

    this.service.addOrEditTrainer(course.courseId).subscribe((response: User[]) => {
      console.log(response);

      for (let i = 0; i < response.length; i++) {
        this.trainers.push(response[i]);
      }
    });

    this.service.getAllEmployees().subscribe((response: User[]) => {
      this.options = [];

      console.log(response);
      for (const obj of response) {
        this.allEmployees.push(obj);
        this.options.push(obj.empName);
      }

      this.filteredOptions = this.myControl.valueChanges.pipe(
        startWith(''),
        map(value => this._filter(value))
      );
    });
    console.log(course);
  }

  modifyCourseScreen(course: Course) {
    this.editMode = true;
    this.modifyCourseId = course.courseId;
    console.log(course);

    this.editCourseForm.setValue({
      editName: course.courseName,
      editDescription: course.courseDescription,
      editLocation: course.courseLocation,
      editSkills: course.courseSkills,
      editPrerequisites: course.coursePrerequisites
    });

  }

  deleteCourse(course: Course) {
    console.log('to Be Deleted', course);
    this.service.deleteCourse(course).subscribe((response) => {
      console.log(response);

      this.ngOnInit();
      this.section = 'Modify/Delete Course';
      this.openSnackBar('Course Deleted Successfully', 'Done');
    });

  }

  assignTrainer() {
    const obj = new Training();
    console.log(this.myControl.value, ' ', this.trainerCourse);

    let trainerId: number;
    for (const itr of this.allEmployees) {
      if (itr.empName === this.myControl.value) {
        trainerId = itr.empId;
        break;
      }
    }

    console.log(trainerId, ' ', this.trainerCourse);

    obj.courseId = this.trainerCourse;
    obj.trainerId = trainerId;

    this.service.assignTrainer(obj).subscribe((response) => {
      console.log(response);
      this.openSnackBar('Trainer Assigned Successfully', 'Done');
      this.goBack();
    });
  }

  unassignTrainer(id) {
    console.log('Trainer Id', id);
    console.log('Course Id', this.trainerCourse);

    const obj = new Training();

    obj.courseId = this.trainerCourse;
    obj.trainerId = id;

    console.log(obj);

    this.service.unAssignTrainer(obj).subscribe((response) => {
      console.log(response);
      this.openSnackBar('Trainer Unassigned Successfully', 'Done');
      this.goBack();
    });

  }

  goBack() {
    this.trainerMode = false;
    this.editMode = false;
    this.trainerCourse = null;
    this.trainers = [];
    this.ngOnInit();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }


}
