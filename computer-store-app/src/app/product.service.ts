import { Injectable } from '@angular/core';
import { Product } from './product';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  product: Product;
  private url:string;

  constructor(private http:HttpClient) { 
    this.url = "http://54.244.36.228:9000/";
  }

  public listProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.url+"products");
  }
}
