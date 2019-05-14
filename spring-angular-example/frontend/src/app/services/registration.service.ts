import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrationForm } from '../model/registration-form.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  // Get the HTTP Client through dependency injection to make HTTP calls
  constructor(private http: HttpClient) { }

  attemptRegistration(registrationForm: RegistrationForm): Observable<any> {
    return this.http.post<any>(environment.api.register, registrationForm);
  }
}
