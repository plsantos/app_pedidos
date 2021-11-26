import { Component, OnInit } from '@angular/core';
import { Pedido } from '../model/pedido';
import { OrderService } from './../services/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  situacao = ['true', 'false']
  order$: Pedido[] = [];
  displayedColumns = ['id', 'cliente', 'data', 'situacao', 'endereco', 'acoes'];

  constructor(private orderService: OrderService) {
  }


   ngOnInit(): void {
    this.orderService.getPedidos()
     .subscribe(data => {
      this.order$ = data;
      console.log(data);

   })
   }

   deletePedido(id: number): void {
    this.orderService.deletePedido(id).subscribe();
    this.order$ = this.order$.filter((p) => p.id != id);
  }

  editar(id: any): void {
    localStorage.setItem("id", id.toString());
   }
  }
