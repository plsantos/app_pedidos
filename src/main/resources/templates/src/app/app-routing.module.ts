import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { PedidoComponent } from './pedido/pedido.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import { EnderecoComponent } from './endereco/endereco.component';
import { ItemOrderComponent } from './item-order/item-order.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { SaveOrderComponent } from './save-order/save-order.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch:'full'},
  { path: 'home', component: HomeComponent },
  { path: 'customerList', component: CustomerListComponent },
  { path: 'productList', component: ProductListComponent },
  { path: 'orderList', component: OrderListComponent },
  { path: 'pedido', component: PedidoComponent },
  { path: 'customerForm', component: CustomerFormComponent },
  { path: 'enderecoForm', component: EnderecoComponent },
  { path: 'cadastroProduto', component: CadastroProdutoComponent},
  { path: 'itensPedido', component: ItemOrderComponent},
  { path: 'header',component: HeaderComponent},
  { path: 'footer',component: FooterComponent},
  { path: 'editCustomer/:id',component: EditCustomerComponent},
  { path: 'saveOrder', component: SaveOrderComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
