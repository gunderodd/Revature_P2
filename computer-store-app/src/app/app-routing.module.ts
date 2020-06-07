import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{CreateUserComponent} from './create-user/create-user.component';
import{UserListComponent} from './user-list/user-list.component';


const routes: Routes = [
  {path:"user", component:CreateUserComponent},
  {path:"users", component:UserListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
