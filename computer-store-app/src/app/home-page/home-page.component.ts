import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  products:Product[];

  constructor(private service: ProductService) { }

  ngOnInit(): void {

    this.service.listProducts().subscribe(data=>{
      this.products=data.slice(1,5);
    });

  }

}
