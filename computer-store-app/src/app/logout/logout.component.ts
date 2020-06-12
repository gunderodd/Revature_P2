import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private authentocationService: LoginPageComponent,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.authentocationService.logOut();
    this.router.navigate(['homepage']);
  }

}
