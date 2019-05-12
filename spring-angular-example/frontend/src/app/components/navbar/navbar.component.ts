import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  // Through dependency injection, get the LoginService to perform logou
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    this.loginService.attemptLogout().subscribe(
      success => {
        sessionStorage.removeItem("currentUser");
        this.router.navigate([""]);
      }
    )
  }
}
