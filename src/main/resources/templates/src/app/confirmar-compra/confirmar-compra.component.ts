import { Component, OnInit } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';
import { ItemOrderService } from '../services/item-order.service';

@Component({
  selector: 'app-confirmar-compra',
  templateUrl: './confirmar-compra.component.html',
  styleUrls: ['./confirmar-compra.component.css']
})
export class ConfirmarCompraComponent implements OnInit {

  listaItensPedido: ItensPedido[] = [];
  displayedColumns = ['id_pedido', 'nome', 'data','valor','status', 'acoes' ];

  constructor(private itemOrder: ItemOrderService) { }

  ngOnInit(): void {
    this.itemOrder.getItensPedido()
    .subscribe(data => {
      this.listaItensPedido = data
    })
  }

}
