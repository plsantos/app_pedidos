import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from '../model/pedido';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-save-order',
  templateUrl: './save-order.component.html',
  styleUrls: ['./save-order.component.css']
})
export class SaveOrderComponent implements OnInit {
  pedido: Pedido = new Pedido();
  status = ['True', 'False']

  constructor(
    private orderService: OrderService,
    private router: Router,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
  }

  savePedido() {
    this.orderService.savePedido(this.pedido).subscribe((data) => {
      this.router.navigate(['/orderList']);
    });
  }
  

}
