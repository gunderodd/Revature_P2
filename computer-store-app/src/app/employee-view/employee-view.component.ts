import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {
  public product: Product;
  public products:Product[];
//   public filteredProducts: Product[];

  // constructor() { }
//   actualInputfield = '';

//   get inputField(){
//     return this.actualInputfield;
//   }
//   set inputField(temp:string){
//     this.actualInputfield = temp;
//     this.filteredProducts = this.actualInputfield?
//         this.performFilter(this.inputField) : this.products;
// }

// performFilter(filterValue: string): Product[]{
//   filterValue = filterValue.toLocaleLowerCase();

//   return this.products.filter(
//     (products:Product)=>
//     products.name.toLocaleLowerCase().indexOf(filterValue)!== -1
//   );
// }

  constructor(private service: ProductService, private router:Router) {
    // this.filteredProducts = this.products
   }

   restockOrders(name, stock){
     console.log(stock)
     console.log(name)
     this.service.restockOrders(name, stock).subscribe(res=> this.router.navigate(['employeeview']));
   }

  ngOnInit() {
    this.service.getAllProducts().subscribe(data=>{
      this.products = data;
    });
  }

}
