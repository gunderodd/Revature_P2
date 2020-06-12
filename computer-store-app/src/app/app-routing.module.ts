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
  { path: "adminview", component: AdminViewComponent},

  // { path: "logout", component: LogoutComponent}
  { path: "logout", component: LogoutComponent, canActivate:[LoginSessionService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
