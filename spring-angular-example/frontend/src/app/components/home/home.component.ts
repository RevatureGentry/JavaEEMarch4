import { Component, OnInit } from '@angular/core';
import { UserInfoService } from 'src/app/services/user-info.service';
import { UserInfo } from 'src/app/model/user-info.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userInfo: UserInfo;

  constructor(private userInfoService: UserInfoService) { }

  ngOnInit() {
    // As soon as we hit the Home page, request the current user Info from the backend
    this.userInfoService.getUserInfo().subscribe(
      success => this.userInfo = success
    );
  }

}
