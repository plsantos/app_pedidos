import { Component, OnInit } from '@angular/core';
import { Pedido } from '../model/pedido';
import { OrderService } from './../services/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  situacao = ['true', 'false'];
  order$: Pedido[] = [];
  displayedColumns = [
    'id',
    'cliente',
    'data',
    'situacao',
    'endereco',
    'valor',
    'acoes',
  ];

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.buscarPedido();
  }

  buscarPedido() {
    this.orderService.getPedidos().subscribe((data) => {
      this.order$ = data;
      console.log(data);
    });
  }

  editar(id: any): void {
    localStorage.setItem('id', id.toString());
  }
}
