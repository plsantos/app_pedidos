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

  order$: Pedido[] = [];
  displayedColumns = ['id', 'cliente', 'data', 'valorTotal', 'situacao', 'acoes'];

  constructor(private orderService: OrderService) {
  }


   ngOnInit(): void {
    this.orderService.getPedidos()
     .subscribe(data => {
      this.order$ = data;
      console.log(data);

   })
   }

  }
