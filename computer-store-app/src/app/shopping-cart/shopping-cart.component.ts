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
  orderProductList:OrderProduct[];

  constructor(private os:OrderService, private ops:OrderProductService) { }

  ngOnInit(): void {
    // here it is firing for "cart"
    this.os.getUserCart().subscribe(res => {
      console.log(res);
      this.cart = res;
      this.ops.getOrderProductsByOrder(this.cart).subscribe(res2 => {
        this.orderProductList = res2;
      });
    });

  }

  updateOrderProduct(pid) {
    let quantity = (<HTMLInputElement>document.getElementById(pid)).value;

    this.ops.updateOrderProduct(pid, quantity).subscribe( res => {
      console.log(res);
      // display the result to the user?
      // or just ensure that the result is good, then just put a checkmark somewhere
      // or we can have the row flash green???
      // also have to worry about updating the list and everything after we make changes to OPs and stuff
    });
  }

  buyCart() {
    this.os.buyCart().subscribe( res => {
      console.log(res);
    });
  }

  clearCart() {
    this.os.clearCart().subscribe( res => {
      console.log(res);
    });
  }
}
