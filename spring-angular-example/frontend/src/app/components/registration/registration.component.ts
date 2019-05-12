import { Component, OnInit } from '@angular/core';
import { RegistrationService } from 'src/app/services/registration.service';
import { RegistrationForm } from 'src/app/model/registration-form.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  regForm: RegistrationForm = {
    username: "",
    password: "",
    email: "",
    firstname: "",
    lastname: ""
  }

  messageStyle: string;
  message: string;
  constructor(private registrationService: RegistrationService) { }

  ngOnInit() {
  }

  attemptRegistration() {
    this.registrationService.attemptRegistration(this.regForm).subscribe(
      success => {
        // The RegistrationController returns a JSON response in the form of 
        // { 'message': user.getUsername() + ' registered successfully!'}
        console.log(success);
        this.messageStyle = 'alert alert-success'
        this.message = success.message;
      },
      err => {
        // The RegistrationController returns a JSON response in the form of 
        // { 'message': ERROR_MESSAGE}
        this.messageStyle = 'alert alert-danger'
        this.message = err.error.message;
      }
    )
  }

}
