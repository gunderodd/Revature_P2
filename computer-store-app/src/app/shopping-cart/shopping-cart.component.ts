import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../Services/order.service';
import { OrderProductService } from '../Services/order-product.service';
import { OrderProduct } from '../order-product';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  cart:Order;
  constructor(private os:OrderService, private ops:OrderProductService) { }

  ngOnInit(): void {
    this.os.getUserCart().subscribe(res => {
      console.log(res);
      
      this.cart = res;
    });
  }

  updateOrderProduct(pid:number) {
    let op:OrderProduct;
    op = this.cart.orderProductList.find(obj => {
      return obj.product.productId === pid;
    });
    this.ops.updateOrderProduct(op).subscribe( res => {
      console.log(res);
      // display the result to the user?
      // or just ensure that the result is good, then just put a checkmark somewheregit 
    });
  }

  buyCart() {
    this.os.buyCart(this.cart).subscribe( res => {
      console.log(res);
    });
  }

  clearCart() {
    this.os.buyCart(this.cart).subscribe( res => {
      console.log(res);
    });
  }
}
