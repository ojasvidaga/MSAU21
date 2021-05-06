import { Component, OnInit } from '@angular/core';
import { GoogleLoginProvider, FacebookLoginProvider, AuthService } from 'angular-6-social-login';
import { SocialLoginModule, AuthServiceConfig } from 'angular-6-social-login';
import { Socialusers } from '../../models/login/Socialusers';
import { SocialloginService } from '../../providers/login/sociallogin.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/models/login/user';
import { SessionStorageService } from 'angular-web-storage';
const googleLogoURL = 'https://raw.githubusercontent.com/fireflysemantics/logo/master/Google.svg';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {
  response;
  socialusers = new Socialusers();

  constructor(
    public OAuth: AuthService,
    public loginService: SocialloginService,
    private router: Router,
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer,
    private http: HttpClient,
    public session: SessionStorageService,

  ) {
    this.matIconRegistry.addSvgIcon('logo', this.domSanitizer.bypassSecurityTrustResourceUrl(googleLogoURL));
  }

  ngOnInit() {
    if (this.loginService.getLoginStatus()) {
      this.router.navigate(['/all-courses']);
    }
  }

  public socialSignIn(socialProvider: string) {
    let socialPlatformProvider;
    if (socialProvider === 'google') {
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }
    this.OAuth.signIn(socialPlatformProvider).then(socialusers => {

      // console.log(socialProvider, socialusers);
      this.loginService.validateUser(socialusers.email).subscribe((response: User) => {
        let user = new User();

        user = response;
        user.empImage = socialusers.image;
        this.session.set('user', user);
        console.log('Inside Session', this.session.get('user'));
        this.session.set('reload', true);
        this.router.navigate([`/all-courses`]);
      });


    });
  }
}
