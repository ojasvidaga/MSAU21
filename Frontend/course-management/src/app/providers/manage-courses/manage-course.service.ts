import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from '../../models/course/Course';
import { Training } from 'src/app/models/training/Training';

@Injectable({
  providedIn: 'root'
})

export class ManageCourseService {
  getAllTrainers(id: number) {
    return this.http.get('/api/training/getTrainersByCourseId/' + id);
  }


  constructor(public http: HttpClient) { }

  getAllCourses() {
    return this.http.get('/api/course/all');
  }

  addCourse(obj: Course) {
    return this.http.post('/api/course/addCourse', obj, { responseType: 'text' });
  }

  editCourse(obj: Course) {
    return this.http.post('/api/course/updateCourse', obj, { responseType: 'text' });
  }

  getAllEmployees() {
    return this.http.get('/api/training/getAllEmployees');
  }

  addOrEditTrainer(courseId: number) {
    return this.http.get('/api/training/getTrainersByCourseId/' + courseId);
  }

  unAssignTrainer(obj: Training) {
    return this.http.post('/api/training/unassignTrainers', obj, { responseType: 'text' });
  }

  assignTrainer(obj: Training) {
    return this.http.post('/api/training/assignTrainers', obj, { responseType: 'text' });
  }

  deleteCourse(course: Course) {
    return this.http.post('api/course/deleteCourse', course, { responseType: 'text' });
  }

  getAllCoursesForCurrentTrainer(trainerId: number) {
    return this.http.get('/api/course/trainer/' + trainerId);
  }

}
