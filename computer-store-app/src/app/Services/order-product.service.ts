import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderProduct } from '../order-product';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { Identifiers } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class OrderProductService {
  orderProduct:OrderProduct;
  private url:string;

  constructor(private http:HttpClient, private userService:UserService) { 
    // this.url = "http://localhost:9000/";
    this.url = "http://54.244.36.228:9000/";
  }

	/*
	 * {
	 * 	"order" : { "orderId" : 1 }
	 *  "product" : { "productId" : 1 }
	 *  "quantity" : 1
	 * }
	 */
  public createOrderProduct(id:string, quantity:string) {
    let request = [id, quantity, sessionStorage.getItem('username'), sessionStorage.getItem('password')];
    return this.http.post<OrderProduct>(this.url+"orderproduct",request);
  }

  public updateOrderProduct(id:string, quantity:string): Observable<OrderProduct> {
    let request = [id, quantity, sessionStorage.getItem('username'), sessionStorage.getItem('password')];
    return this.http.put<OrderProduct>(this.url+"orderproduct",request);
  }

  public getOrderProductsByOrder(o:Order): Observable<OrderProduct[]> {
    return this.http.get<OrderProduct[]>(this.url+"orderproducts/order/"+o.id);
  }
}
