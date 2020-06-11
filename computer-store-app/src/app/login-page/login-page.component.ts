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
    
  }

  loginUser(){
    console.log(this.user.username)
    console.log(this.user.password)
    this.service.loginUser(this.user.username, this.user.password).subscribe(res=>
      {if (typeof res === "object"){
        this.service.setCurrentUser(res); this.router.navigate(['customerhome']);
        console.log(res)
      }else if (typeof res === "string"){
        console.log("type is string")
        console.log(res)
      }
      
      
      });
    
  }

  ngOnInit(): void {
  }

}
