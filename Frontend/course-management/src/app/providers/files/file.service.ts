import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SessionStorageService } from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(
    private http: HttpClient,
    private session: SessionStorageService) {

  }

  getVersions(courseId: number) {
    return this.http.get('api/trainingMaterial/fileVersions/' + courseId);
  }

  deleteTraining(fileId: number) {
    return this.http.post('api/trainingMaterial/delete', fileId, { responseType: 'text' });
  }

  addTrainingMaterial(fileList, courseId, trainerId) {
    const formData: FormData = new FormData();

    for (const obj of fileList) {
      formData.append('files[]', obj);
    }

    formData.append('courseId', courseId.courseId);
    formData.append('trainerId', trainerId);
    // const headers = { headers: new HttpHeaders({ enctype: 'multipart/form-data', responseType: 'text' }) };
    return this.http.post('api/trainingMaterial/add', formData, { responseType: 'text' });
  }

  getTrainingMaterial(courseId: number, trainerId: number) {
    return this.http.get('api/trainingMaterial/files/' + courseId + '/' + trainerId);
  }

}
