import { Component, OnInit } from '@angular/core';
import {UserService} from '../Services/user.service';
import { User } from '../user';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  public user: User;

  constructor(private service: UserService, public loginService:LoginPageComponent) { }

  ngOnInit(): void {
    this.user = this.service.getCurrentUser();
    
  }

}
