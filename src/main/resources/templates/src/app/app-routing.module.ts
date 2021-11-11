
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoComponent} from './pedido/pedido.component';
import { HomeComponent} from './home/home.component';

const routes: Routes = [
  { path: 'pedido', component: PedidoComponent},
  { path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
