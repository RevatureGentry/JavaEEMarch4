import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeaderAddingInterceptorService implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // If request is to /login or /register, do not add Auth Token (as it has yet to be defined)
    if (request.url.includes("login") || request.url.includes("register")) {
      request = request.clone({ headers: this.getHeadersWithoutAuthToken()});
      return next.handle(request);
    } else {
      request = request.clone({ headers: this.getHeadersWithAuthToken()});
      return next.handle(request);
    }
  }

  constructor() { }

  private getHeadersWithoutAuthToken(): HttpHeaders {
    return new HttpHeaders({
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, My-Auth-Token',
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Content-Type': 'application/json'
    });
  }

  private getHeadersWithAuthToken(): HttpHeaders {
    return new HttpHeaders({
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, My-Auth-Token',
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Content-Type': 'application/json',
      'My-Auth-Token': `${sessionStorage.getItem("currentUser")}`
    });
  }
}
