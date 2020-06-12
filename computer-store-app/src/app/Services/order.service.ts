import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../order';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private url:string;
  constructor(private userService:UserService, private http:HttpClient) { this.url = "http://54.244.36.228:9000/" }

  public getUserCart() {
    return this.http.get<Order>(this.url+"cart/"+this.userService.getCurrentUser().id);
  }

  public getUserOrders() {
    return this.http.get<Order[]>(this.url+"orders/"+this.userService.getCurrentUser().id);
  }

  public buyCart(o:Order) {
    return this.http.post<Order>(this.url+"buyCart", o);
  }

  public clearCart(o:Order) {
    return this.http.post<Order>(this.url+"clearCart", o);
  }
}
