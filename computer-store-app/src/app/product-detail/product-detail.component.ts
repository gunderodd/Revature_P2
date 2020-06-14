import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  public product:Product;

  constructor(
    private service: ProductService,
    private location: Location,
    private route: ActivatedRoute


  ) { }

  ngOnInit(): void {

    this.getProduct();


  }

  getProduct():void{

    const id = +this.route.snapshot.paramMap.get('productId');
    
    this.service.getProductId(id).subscribe(data=>{
      this.product=data;
    });

  }


  goBack(): void {
    this.location.back();
  }

}
