import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import { UserService} from '../Services/user.service';
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
  }

  loginUser(){
    
    this.service.loginUser(this.user.username, this.user.password).subscribe(res => {
      if (typeof res === "object") {
        this.service.setCurrentUser(res); 

        sessionStorage.setItem('username',res.username);
        sessionStorage.setItem('password',res.password);

        sessionStorage.setItem('user',JSON.stringify(res) );
        var userJSONobject = JSON.parse(sessionStorage.getItem('user'));
        var userOBJECT:User = userJSONobject;
        sessionStorage.setItem('accesslevel',userOBJECT.accessLevel);

        if (userOBJECT.accessLevel == 'cust') {
          this.router.navigate(['customerhome']);
        } else if(userOBJECT.accessLevel == 'emp') {
          this.router.navigate(['employeeview']);
        }

      } else if (typeof res === "string") {
      }
    });
  }


  isUserLoggedIn() {
    var userJSONobject = JSON.parse(sessionStorage.getItem('user'));
    return !(userJSONobject === null);
  }

  isUserAdmin() {
    var user = sessionStorage.getItem('accesslevel');
    return (user == 'emp');

  }

  isUserCustomer() {
    let user = sessionStorage.getItem('accesslevel')
    return (user == 'cust');
  }

  logOut() {
    sessionStorage.clear();
  }

  ngOnInit(): void {
  }
}
