import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';
import { Router } from '@angular/router';
import { OrderService } from '../Services/order.service';
import { Order } from '../order';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {
  public product: Product;
  public products:Product[];
  public order: Order;
  public orders: Order[];
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

  constructor(private service: ProductService, private router:Router, private orderService: OrderService) {
    // this.filteredProducts = this.products
   }

   restockOrders(name, stock){
     console.log(stock)
     console.log(name)
     this.service.restockOrders(name, stock).subscribe(res=> this.router.navigate(['employeeview']));
   }

  ngOnInit() {
    this.orderService.getAllOrders().subscribe(data=>{
      console.log(data)
      this.orders = data;
    })
    this.service.getAllProducts().subscribe(data=>{
      this.products = data;
    });
  }

}
