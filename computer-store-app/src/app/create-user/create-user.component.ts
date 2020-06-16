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
      , error => {
        if (error.status == 400) {
          alert(error.error);
        } else {
          alert('Usernames and Passwords must contain letters and numbers ONLY, and must be between 4 and 16 characters long.');
        }
      });
      this.user = new User();
    }

  ngOnInit(){
    document.getElementById('passinput').addEventListener('keypress', function (e) {
      var key = e.which || e.keyCode;
      if (key === 13) { // 13 is enter key
        document.getElementById('submitbutton').click();
      }
    });
  }

}
