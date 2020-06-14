import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { OrderService } from '../Services/order.service';
import { Order } from '../order';


@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {
  public order: Order;
  public orders: Order[];


  constructor(
    private location: Location,
    private orderService: OrderService
    ) {}
    
    goBack(): void {
      this.location.back();
    }

  ngOnInit() {
    this.orderService.getUserOrders().subscribe(data=>{
      this.orders = data;
    })

    // this.orderService.getAllOrders().subscribe(data=> {
    //   console.log(data)
    //   this.orders = data;
    // });
  };


}
