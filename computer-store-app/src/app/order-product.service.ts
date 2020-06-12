import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderProduct } from './order-product';
import { UserService } from './Services/user.service';

@Injectable({
  providedIn: 'root'
})
export class OrderProductService {
  orderProduct:OrderProduct;
  private url:string;

  constructor(private http:HttpClient, private userService:UserService) { 
    this.url = "http://54.244.36.228:9000/";
  }

  public putInUserCart(orderProduct:OrderProduct) {
    return this.http.post<OrderProduct>(this.url+"orderproduct",orderProduct);
  }

}
