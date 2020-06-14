import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../order';
import { UserService } from './user.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private url:string;
  constructor(private userService:UserService, private http:HttpClient) { this.url = "http://54.244.36.228:9000/" }

  public getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.url+"orders");
  }

  public getUserCart(): Observable<Order> {
    return this.http.get<Order>(this.url+"cart");
  }

  public getUserOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.url+"orders/"+this.userService.getCurrentUser().id);
  }

  public buyCart(o:Order): Observable<Order> {
    return this.http.post<Order>(this.url+"buyCart", o);
  }

  public clearCart(o:Order): Observable<Order> {
    return this.http.post<Order>(this.url+"clearCart", o);
  }
}
