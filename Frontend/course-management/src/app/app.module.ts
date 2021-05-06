import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Libraries
import { HttpClientModule } from '@angular/common/http';
import { GoogleLoginProvider, AuthService } from 'angular-6-social-login';
import { AuthServiceConfig } from 'angular-6-social-login';
import { AngularWebStorageModule } from 'angular-web-storage';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartsModule } from 'ng2-charts';

// Directives
import { DragDropDirective } from './utils/directives/drag-drop.directive';

// Screens
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ViewAllCoursesComponent } from './components/view-all-courses/view-all-courses.component';
import { UploadFileComponent } from './components/upload-file/upload-file.component';
import { ViewDeleteFileComponent } from './components/view-delete-file/view-delete-file.component';
import { PieChartComponent } from './components/pie-chart/pie-chart.component';
import { LineChartComponent } from './components/line-chart/line-chart.component';
import { BarChartComponent } from './components/bar-chart/bar-chart.component';
import { SendMailComponent } from './components/send-mail/send-mail.component';
import { ViewTrainingComponent } from './components/view-training/view-training.component';
import { VersionComponent } from './components/version/version.component';

// Material
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule } from '@angular/material';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ManageCoursesComponent } from './components/manage-courses/manage-courses.component';
import { MyCoursesComponent } from './components/my-courses/my-courses.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatRadioModule } from '@angular/material/radio';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatDialogModule } from '@angular/material/dialog';


export function socialConfigs() {
  const config = new AuthServiceConfig(
    [
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider('430541210732-c3dplun832vl4ruja9m2t1a9do1gpt7i.apps.googleusercontent.com')
      }
    ]
  );
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    PageNotFoundComponent,
    ViewAllCoursesComponent,
    ManageCoursesComponent,
    MyCoursesComponent,
    UploadFileComponent,
    DragDropDirective,
    ViewDeleteFileComponent,
    PieChartComponent,
    LineChartComponent,
    BarChartComponent,
    SendMailComponent,
    ViewTrainingComponent,
    VersionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularWebStorageModule,
    FormsModule,
    ReactiveFormsModule,
    ChartsModule,

    // Material Imports
    MatSidenavModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatCardModule,
    MatDividerModule,
    MatListModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTabsModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSlideToggleModule,
    MatGridListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSnackBarModule,
    MatRadioModule,
    MatAutocompleteModule,
    MatDialogModule
  ],
  providers: [
    AuthService,
    {
      provide: AuthServiceConfig,
      useFactory: socialConfigs
    }
  ],
  entryComponents: [
    UploadFileComponent,
    ViewDeleteFileComponent,
    SendMailComponent,
    ViewTrainingComponent,
    VersionComponent
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
