import { Component, OnInit } from '@angular/core';
import { Pedido } from '../model/pedido';
import { OrderService } from './../services/order.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  order$: Observable<Pedido[]>;
  displayedColumns = ['id', 'cliente', 'dataPedido', 'valorTotal', 'situacao', 'acoes'];

 constructor(private orderService: OrderService) {
   this.order$ = this.orderService.findAll();
 }

 ngOnInit(): void {

 }
}
