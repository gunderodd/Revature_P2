import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import { UserService} from '../Services/user.service';
import {Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  user:User;

  constructor(private service:UserService, private router:Router) {
    this.user= new User();
    }

    createUser(){
      this.service.createUser(this.user.username, this.user.password).subscribe(res=>this.router.navigate(['loginpage'])
      , error =>{
        alert('Username and Password must only have letters and numbers, no spaces');
      }
      );
      this.user = new User();
    }

  ngOnInit(){
  }

}
