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
    console.log(this.user.username)
    console.log(this.user.password)
    this.service.loginUser(this.user.username, this.user.password).subscribe(res => {
      if (typeof res === "object") {
        this.service.setCurrentUser(res); this.router.navigate(['customerhome']);
        sessionStorage.setItem('username',this.user.username);
        let test = sessionStorage.getItem('username');
        console.log(test);
        console.log(res);
      } else if (typeof res === "string") {
        console.log("type is string");
        console.log(res);
      }
    });
  }

  // how come we're not just storing the entire User object in the session?
  // Also, if we're going to use SessionStorage, we might want to get rid of the
  // stuff we have in UserService regarding storing the current user in a field.
  // Also, maybe this function would be better in the UserService. -WK
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  ngOnInit(): void {
  }
}
