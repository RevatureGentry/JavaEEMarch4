import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginForm } from '../model/login-form.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // Use dependency injection to get the object required to make HTTP calls in this Service
  constructor(private http: HttpClient) { }

  // Helper function to encapsulate logging in
  attemptLogin(loginForm: LoginForm): Observable<any> {
    return this.http.post<any>(environment.api.login, loginForm);
  }

  attemptLogout(): Observable<any> {
    return this.http.post<any>(environment.api.logout, {});
  }
}
