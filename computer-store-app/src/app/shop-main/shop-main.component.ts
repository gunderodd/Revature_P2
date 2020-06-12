import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';

@Component({
  selector: 'app-shop-main',
  templateUrl: './shop-main.component.html',
  styleUrls: ['./shop-main.component.css']
})
export class ShopMainComponent implements OnInit {

  products:Product[];

  constructor(private service: ProductService) { }

  ngOnInit(): void {
    console.log("we are in the shop init");
    
    this.service.listProducts().subscribe(data=>{
      this.products=data;
    });
  }

  addToCart(id) {
    let amount = (<HTMLInputElement>document.getElementById(id)).value;
    console.log(id);
    console.log(amount);

    /* user orderproductservice
	   * {
	   * 	"order" : {  } empty, gets cart on EC2 side
	   *  "product" : { "productId" : id }
	   *  "quantity" : amount
     * }
	   */
  }
}
