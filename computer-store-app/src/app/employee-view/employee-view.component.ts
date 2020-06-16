import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../Services/product.service';
import { Router } from '@angular/router';
import { OrderService } from '../Services/order.service';
import { Order } from '../order';
import { Validators } from '@angular/forms';

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
  public show: boolean = false;
  public secondShow: boolean = false;
  public buttonName: any = "Show Orders";
  public secondButtonName: any = "Show Inventory List";
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
    toggle() {
    this.show = !this.show;

    if(this.show){
    this.buttonName = "Hide Orders";
    }else{
    this.buttonName = "Show Orders";
  }}
  secondToggle() {
    this.secondShow = !this.secondShow;

    if (this.secondShow) {
      this.secondButtonName= "Hide Inventory List";
    } else {
      this.secondButtonName = "Show Inventory List";
    }
  }

  restockOrders(product:Product) {
    let quantity = (<HTMLInputElement>document.getElementById(product.id.toString())).value;
    if (parseInt(quantity) <= product.stock && parseInt(quantity) > 0) {
      product.stock = product.stock + parseInt(quantity);
      this.service.restockOrders(product.name, product.stock).subscribe(res => {this.ngOnInit();});
    } else {
      alert('Invalid amount entered. Ensure you are not buying more than we have in stock, and that you\'re entering a positive non-zero value.');
    }
  }

  ngOnInit() {
    this.orderService.getAllOrders().subscribe(data=>{
      this.orders = data;
    })
    this.service.getAllProducts().subscribe(data=>{
      this.products = data;
    });
  }

}
