import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SessionStorageService } from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})

export class SocialloginService {

  url;

  constructor(private http: HttpClient, public session: SessionStorageService) {

  }

  Savesresponse(response) {
    this.url = 'http://localhost:64726/Api/Login/Savesresponse';
    return this.http.post(this.url, response);
  }

  validateUser(email) {
    return this.http.get('/api/login/validateUser/' + email);
  }

  // setLoginStatus(val: boolean) {
  //   this.loggedIn = val;
  // }

  getLoginStatus() {
    if (this.session.get('user') === null) {
      return false;
    } else {
      return true;
    }
  }

}
