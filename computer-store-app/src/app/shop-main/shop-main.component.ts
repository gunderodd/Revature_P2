import { Component, OnInit } from '@angular/core';
import { PRODUCTS } from '../mock-product';

@Component({
  selector: 'app-shop-main',
  templateUrl: './shop-main.component.html',
  styleUrls: ['./shop-main.component.css']
})
export class ShopMainComponent implements OnInit {

  
  products = PRODUCTS;

  constructor() { }

  ngOnInit(): void {
  }

  addToCart(id) {
    let amount = (<HTMLInputElement>document.getElementById(id)).value;
    console.log(id);
    console.log(amount);
    
    
  }

}
