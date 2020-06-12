import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderProduct } from '../order-product';
import { UserService } from './user.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderProductService {
  orderProduct:OrderProduct;
  private url:string;

  constructor(private http:HttpClient, private userService:UserService) { 
    this.url = "http://54.244.36.228:9000/";
  }

	/*
	 * {
	 * 	"order" : { "orderId" : 1 }
	 *  "product" : { "productId" : 1 }
	 *  "quantity" : 1
	 * }
	 */
  public putInUserCart(op:OrderProduct): Observable<OrderProduct> {
    return this.http.post<OrderProduct>(this.url+"orderproduct",op);
  }

  public updateOrderProduct(op:OrderProduct): Observable<OrderProduct> {
    return this.http.put<OrderProduct>(this.url+"orderproduct",op);
  }
}