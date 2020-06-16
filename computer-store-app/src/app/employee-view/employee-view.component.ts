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

    if(this.secondShow){
    this.secondButtonName= "Hide Inventory List";
    }else{
    this.secondButtonName = "Show Inventory List";
  }}
   restockOrders(name, stock){
     if(stock >=0 ){
     this.service.restockOrders(name, stock).subscribe(res=> window.location.reload());
    } else{
        alert('Invalid Restock Amount');
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
