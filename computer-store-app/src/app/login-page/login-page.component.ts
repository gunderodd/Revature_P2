import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import { UserService} from '../user.service';
import {Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  user:User;

  constructor(private service:UserService, private router:Router) {
    this.user= new User();
    // console.log(this.user.username);
  }

  loginUser(username, password) : void {
    console.log("user login fired on component");
    console.log(username);
    console.log(password);
    
    
    this.service.loginUser(username, password).subscribe(res=>this.router.navigate(['customerhome']));
    // this.service.createUser(this.user).subscribe(res=>this.router.navigate(['customerhome']));
    // this.user = new User();
  }

  ngOnInit(): void {
  }

}
