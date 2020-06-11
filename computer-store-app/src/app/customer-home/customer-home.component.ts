import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { User } from '../user';


@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  public user: User;

  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.user = this.service.getCurrentUser();
    
  }

}
