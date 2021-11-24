import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatIconModule } from '@angular/material/icon';
import { MatSliderModule } from '@angular/material/slider';
import { MatTableModule } from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { OrderListComponent } from './order-list/order-list.component';
import { PedidoComponent } from './pedido/pedido.component';
import { ProductListComponent } from './product-list/product-list.component';
import { EnderecoComponent } from './endereco/endereco.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import { RouterModule } from '@angular/router';
import { ItemOrderComponent } from './item-order/item-order.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { PaginationComponent } from './shared/pagination/pagination.component';
// import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';








@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ItemOrderComponent,
    HeaderComponent,
    FooterComponent,
    PaginationComponent,
    CustomerListComponent,
    ProductListComponent,
    OrderListComponent,
    PedidoComponent,
    EnderecoComponent,
    ItemOrderComponent,
    CustomerFormComponent,
    CadastroProdutoComponent,
    EditCustomerComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSliderModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatIconModule,
    MatCardModule,
    HttpClientModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDividerModule,
    MatRadioModule,
    FormsModule,
    RouterModule,
    BrowserAnimationsModule,
    MatSliderModule,
    //NgxPaginationModule,
    MatToolbarModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})

export class AppModule { }
