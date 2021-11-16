import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ItemOrderComponent } from './item-order/item-order.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'item-order', component: ItemOrderComponent},
  {path: 'header',component: HeaderComponent},
  {path: 'footer',component: FooterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

