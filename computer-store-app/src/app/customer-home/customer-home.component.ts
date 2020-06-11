import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  private usernameCookie: string;

  constructor(private cookieService: CookieService) { }

  ngOnInit(): void {
    this.usernameCookie = this.cookieService.get('username');
    console.log(this.usernameCookie);
  }

}
