import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../Services/order.service';
import { OrderProductService } from '../Services/order-product.service';
import { OrderProduct } from '../order-product';
import { async } from '@angular/core/testing';

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
    this.os.getUserCart().subscribe(res => {
      this.ops.getOrderProductsByOrder(res).subscribe(res2 => {
        this.orderProductList = res2;
        this.cart = res;
      });
    });
  }

  updateOrderProduct(pid, op:OrderProduct) {
    let quantity = (<HTMLInputElement>document.getElementById(pid)).value;
    if (parseInt(quantity) < op.product.stock && parseInt(quantity) > 0) {
      op.product.stock = op.product.stock + (op.quantity - parseInt(quantity));
      op.quantity = parseInt(quantity);
    } else {
      alert('Invalid amount entered. Ensure you are not buying more than we have in stock, and that you\'re entering a positive non-zero value.');
    }
    this.ops.updateOrderProduct(pid, quantity).subscribe();
  }

  buyCart() {
    this.os.buyCart().subscribe(res => {this.ngOnInit();});
  }

  clearCart() {
    this.os.clearCart().subscribe(res => {this.ngOnInit();});
    
  }
}
