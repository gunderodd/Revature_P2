import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserListComponent } from './user-list/user-list.component';
import {UserService} from './user.service';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { StorecardComponent } from './storecard/storecard.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { ReturnItemsComponent } from './return-items/return-items.component';
import { ShopMainComponent } from './shop-main/shop-main.component';
import { LoginPageComponent } from './login-page/login-page.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    UserListComponent,
    CustomerHomeComponent,
    StorecardComponent,
    PurchaseHistoryComponent,
    ReturnItemsComponent,
    ShopMainComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
