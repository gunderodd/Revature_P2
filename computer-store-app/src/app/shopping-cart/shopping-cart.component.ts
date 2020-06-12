import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { OrderProductService } from '../order-product.service';

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
      this.cart = res;
    });
  }

  // addToCart(pid:number) {
  //   this.ops.updateOrderProduct().subscribe( res => {
  //     // display the result to the user?
  //     // or just ensure that the result is good, then just put a checkmark somewhere
  //   });
  // }
}
