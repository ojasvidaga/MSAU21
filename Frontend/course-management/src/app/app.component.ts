import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';
import { SocialloginService } from '../app/providers/login/sociallogin.service';
import { SocialLoginModule, AuthServiceConfig, AuthService } from 'angular-6-social-login';
// import { Socialusers } from '../../models/login/Socialusers';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'course-management';
  sessionName: string;


  loggedIn: boolean;
  constructor(
    public router: Router,
    public session: SessionStorageService,
    public loginService: SocialloginService,
    public OAuth: AuthService) {
  }

  ngOnInit() {
    console.log("Hello! I'm logging you in");
    this.loggedIn = this.loginService.getLoginStatus();
    if (this.loggedIn) {
      this.sessionName = this.session.get('user').empName;
    }
  }

  getImgUrl() {
    return 'url(' + this.session.get('user').empImage + ')';
  }

  logout() {
    this.session.remove('user');
    this.loggedIn = this.loginService.getLoginStatus();
    this.OAuth.signOut().then(data => {
      this.router.navigate(['/login']);
    });

  }
}
