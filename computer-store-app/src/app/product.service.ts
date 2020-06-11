import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  product: Product;
  private url:string;

  constructor(private http:HttpClient) { 
    this.url = "http://54.244.36.228:9000/";
  }
  public getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.url+"products");
  }
  public restockOrders(stock){
    return this.http.post<Product>(this.url+"restock", stock);
  }
}
