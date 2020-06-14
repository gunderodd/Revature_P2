import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from './create-user/create-user.component';
import {UserListComponent} from './user-list/user-list.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { ReturnItemsComponent } from './return-items/return-items.component';
import { StorecardComponent } from './storecard/storecard.component';
import { ShopMainComponent } from './shop-main/shop-main.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';
import { AdminViewComponent } from './admin-view/admin-view.component';
import { LoginSessionService } from './Services/login-session.service';
import { LogoutComponent } from './logout/logout.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';


const routes: Routes = [
  { path:"user", component:CreateUserComponent},
  { path:"users", component:UserListComponent},
  { path: "customerhome", component: CustomerHomeComponent},
  { path: "purchasehistory", component: PurchaseHistoryComponent},
  { path: "returnitems", component: ReturnItemsComponent},
  { path: "storecard", component: StorecardComponent},
  
  // { path: "shopmain", component: ShopMainComponent },
  { path: "shopmain", component: ShopMainComponent, canActivate:[LoginSessionService] },


  { path: "loginpage", component: LoginPageComponent},
  { path: "employeeview", component: EmployeeViewComponent},
  { path: "shoppingcart", component: ShoppingCartComponent},

  { path: "adminview", component: AdminViewComponent},
  { path: "homepage", component: HomePageComponent},
  { path: "logout", component: LogoutComponent, canActivate:[LoginSessionService]},
  { path: 'productDetail/:id', component: ProductDetailComponent},
  { path: 'shoppingcart', component: ShoppingCartComponent},

// ALWAYS MAKE SURE THIS IS THE LAST ROUTE OR THE PROGRAM WILL BREAK
  { path: '**', component: HomePageComponent},





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
