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
  quant:number;
  products:Product[];

  constructor(private service: ProductService, private opservice: OrderProductService) { }

  ngOnInit(): void {
    
    this.service.listProducts().subscribe(data=>{
      this.products=data;
    });
  }

  addToCart(id, product:Product) {
    let quantity = (<HTMLInputElement>document.getElementById(id)).value;
      if (parseInt(quantity) <= product.stock && parseInt(quantity) > 0) {
        product.stock = product.stock - parseInt(quantity);
      } else {
        alert('Invalid amount entered. Ensure you are not buying more than we have in stock, and that you\'re entering a positive non-zero value.');
      }
    
    this.opservice.createOrderProduct(id, quantity).subscribe(data => {
    })
  }
}
