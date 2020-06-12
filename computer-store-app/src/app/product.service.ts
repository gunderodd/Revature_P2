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
  
  public restockOrders(name, stock){
    return this.http.put<Product>(this.url+"product" + "/"+ name + "/" + stock, {name, stock});
  }

  public listProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.url+"products");
  }
}
