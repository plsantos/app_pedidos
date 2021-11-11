import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ItensPedidoComponent } from './itens-pedido/itens-pedido.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'itens', component: ItensPedidoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

