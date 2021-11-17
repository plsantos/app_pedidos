import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSliderModule } from '@angular/material/slider';

import { MatTableModule } from '@angular/material/table';

import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { HomeComponent } from './home/home.component';
import { ProductListComponent } from './product-list/product-list.component';
import {MatButtonModule} from '@angular/material/button';
import { OrderListComponent } from './order-list/order-list.component';
import {MatCheckboxModule} from '@angular/material/checkbox';

import { PedidoComponent } from './pedido/pedido.component';
import { EnderecoComponent } from './endereco/endereco.component';
import { ItemOrderComponent } from './item-order/item-order.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustomerListComponent,
    ProductListComponent,
    OrderListComponent,
    PedidoComponent,
    EnderecoComponent,
    ItemOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSliderModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatIconModule,
    MatCardModule,
    MatToolbarModule,
    HttpClientModule,
    MatButtonModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
