import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderListComponent } from './order-list/order-list.component';






const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'customerList', component: CustomerListComponent},
  {path: 'productList', component: ProductListComponent},
  {path: 'orderList', component: OrderListComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
