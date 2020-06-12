import { Component, OnInit } from '@angular/core';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-header-page',
  templateUrl: './header-page.component.html',
  styleUrls: ['./header-page.component.css']
})
export class HeaderPageComponent implements OnInit {

  constructor( public loginService:LoginPageComponent) { }
  // constructor( public MyLoginService:LoginPageComponent) { 
  //   MyLoginService.isUserLoggedIn();
  // }

  ngOnInit(): void {
  }

}
