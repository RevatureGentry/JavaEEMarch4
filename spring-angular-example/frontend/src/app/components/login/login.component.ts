import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { LoginForm } from 'src/app/model/login-form.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: LoginForm = {
    username: "",
    password: ""
  }

  // Get the login service via dependency injection
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }


  attemptLogin() {
    // To send the HTTP request, we invoke the loginService.attemptLogin() function
    // Since the loginService.attemptLogin() function returns an Observable, we must subscribe to it in order for anything to happen

    // the subscribe function takes up to 3 callback functions
    // The first callback function is for a successful response
    // The second callback function is for a failed response
    // The third callback (not shown here) works similar to a finally block in Java
    this.loginService.attemptLogin(this.loginForm).subscribe(
      success => {
        // Since our server sends a JSON in the form of {"token": "..."}, we access it as such
        console.log("Successful response sent from server: " + success.token);

        // Once we have the token, set it in sessionStorage
        sessionStorage.setItem("currentUser", success.token);

        // Once the token is set, use the router to navigate to the homepage
        this.router.navigate(["/home"])
      },
      error => {
        console.log("Error response sent from server: " + error.message);
      }
    )
  }
}
