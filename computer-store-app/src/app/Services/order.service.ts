import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../order';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})

export class OrderService {
  private url:string;
  constructor(private userService:UserService, private http:HttpClient) { 
    // this.url = "http://localhost:9000/";
    this.url = "http://54.244.36.228:9000/"; 
  }

  public getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.url+"orders");
  }

  public getUserCart(): Observable<Order> {
    let request = [sessionStorage.getItem('username'), sessionStorage.getItem('password')];
    return this.http.post<Order>(this.url + "getusercart", request);
  }

  public getUserOrders(): Observable<Order[]> {
    var userJSONobject = JSON.parse(sessionStorage.getItem('user'));
    var userOBJECT:User = userJSONobject;
    var id = userOBJECT.id;
    console.log(id);
    
    return this.http.get<Order[]>(this.url+"orders/"+id);
  }

  public buyCart(): Observable<Order> {
    let request = [sessionStorage.getItem('username'), sessionStorage.getItem('password')];
    return this.http.put<Order>(this.url+"buycart", request);
  }

  public clearCart(): Observable<Order> {
    let request = [sessionStorage.getItem('username'), sessionStorage.getItem('password')];
    return this.http.put<Order>(this.url+"clearcart", request);
  }
}
