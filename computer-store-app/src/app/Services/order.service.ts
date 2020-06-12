import { Injectable } from '@angular/core';
import { Order } from '../order';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  order: Order;
  private url:string;
  constructor(private http:HttpClient) { 
    this.url = "http://54.244.36.228:9000/";
  }

  public getAllOrders(): Observable<Order[]>{
    return this.http.get<Order[]>(this.url+"orders");
  }
}
