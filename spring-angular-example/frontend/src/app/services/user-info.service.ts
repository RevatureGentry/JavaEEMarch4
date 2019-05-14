import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from '../model/user-info.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {

  // This service is used to get the UserInfo Data Transfer Object from the Spring Backend
  // We use the because our backend is Stateless

  // Use dependency injection to get the object required to make HTTP calls in this Service
  constructor(private http:HttpClient) { }

  getUserInfo(): Observable<UserInfo> {
    return this.http.get<UserInfo>(environment.api.userInfo);
  }
}
