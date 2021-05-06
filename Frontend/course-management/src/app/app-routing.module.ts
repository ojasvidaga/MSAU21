import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ManageCoursesComponent } from './components/manage-courses/manage-courses.component';
import { MyCoursesComponent } from './components/my-courses/my-courses.component';
import { ViewAllCoursesComponent } from './components/view-all-courses/view-all-courses.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'all-courses', component: ViewAllCoursesComponent },
  { path: 'manage-courses', component: ManageCoursesComponent },
  { path: 'assigned-courses', component: MyCoursesComponent },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
