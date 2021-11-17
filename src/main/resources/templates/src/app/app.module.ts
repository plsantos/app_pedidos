import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
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
import { OrderListComponent } from './order-list/order-list.component';
import { PedidoComponent } from './pedido/pedido.component';
import { ProductListComponent } from './product-list/product-list.component';
import { EnderecoComponent } from './endereco/endereco.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';
import {MatRadioModule} from '@angular/material/radio';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustomerListComponent,
    ProductListComponent,
    OrderListComponent,
    PedidoComponent,
    EnderecoComponent,
    CustomerFormComponent,
    CadastroProdutoComponent
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
    MatFormFieldModule,
    MatSelectModule,
    MatDividerModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
