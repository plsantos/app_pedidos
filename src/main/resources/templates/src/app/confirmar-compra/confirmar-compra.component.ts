import { Component, OnInit } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';
import { ItemOrderService } from '../services/item-order.service';

@Component({
  selector: 'app-confirmar-compra',
  templateUrl: './confirmar-compra.component.html',
  styleUrls: ['./confirmar-compra.component.css']
})
export class ConfirmarCompraComponent implements OnInit {

  listaPedido: ItensPedido[] = [];
  displayedColumns = ['id', 'nome','endereço', 'data','valor','valorDesconto' ];

  constructor(private itemOrder: ItemOrderService) { }

  ngOnInit() {
    this.itemOrder.getItensPedido()
    .subscribe(data => {
      this.listaPedido = data
    })
  }

}
