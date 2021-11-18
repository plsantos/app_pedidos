import { Component, OnInit } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';
import { Router } from '@angular/router';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-item-order',
  templateUrl: './item-order.component.html',
  styleUrls: ['./item-order.component.css']
})
export class ItemOrderComponent implements OnInit {

  itens_pedido$: ItensPedido[] = [];
  displayedColumns = ['id', 'idPedido', 'idProduto', 'quantidade', 'valorTotal'];

 constructor(private orderService: OrderService, private router: Router) {
  this.order$ = this.orderService.findAll();
 }



  ngOnInit(): void {
   
  }

}
