import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AuthGuardService } from './services/auth-guard.service';
import { RegistrationComponent } from './components/registration/registration.component';
import { CreateTweetComponent } from './components/create-tweet/create-tweet.component';

const routes: Routes = [
  // Set the default path to route to LoginComponent
  { path: '', component: LoginComponent},
  { path: 'register', component: RegistrationComponent},
  { path: 'tweets', component: CreateTweetComponent, canActivate: [AuthGuardService]},
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService]},


  // If a request is made to any unknown route, go to LoginComponent
  { path: "**", redirectTo: "/", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
