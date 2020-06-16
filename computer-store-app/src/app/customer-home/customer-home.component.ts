import { Component, OnInit } from '@angular/core';
import {UserService} from '../Services/user.service';
import { User } from '../user';
import { LoginPageComponent } from '../login-page/login-page.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  public user: User;

  public test = sessionStorage.getItem('username');

  constructor(private service: UserService, public loginService:LoginPageComponent, private router: Router) { }

  ngOnInit(): void {
    this.user = this.service.getCurrentUser();
    
  }
  viewHistory(){
    this.router.navigate(['purchasehistory']);
  }

}
