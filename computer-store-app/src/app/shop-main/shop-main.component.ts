import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';
import { OrderProductService } from '../Services/order-product.service';

@Component({
  selector: 'app-shop-main',
  templateUrl: './shop-main.component.html',
  styleUrls: ['./shop-main.component.css']
})
export class ShopMainComponent implements OnInit {

  products:Product[];

  constructor(private service: ProductService, private opservice: OrderProductService) { }

  ngOnInit(): void {
    
    this.service.listProducts().subscribe(data=>{
      this.products=data;
    });
  }

  addToCart(id) {
    let quantity = (<HTMLInputElement>document.getElementById(id)).value;
     
    
    this.opservice.createOrderProduct(id, quantity).subscribe(data => {
    })
  window.location.reload();
}
}
