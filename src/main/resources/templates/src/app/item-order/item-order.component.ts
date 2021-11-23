import { Component, OnInit } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';
import { Produto } from '../model/produto';
import { ItemOrderService } from '../services/item-order.service';

@Component({
  selector: 'app-item-order',
  templateUrl: './item-order.component.html',
  styleUrls: ['./item-order.component.css']
})
export class ItemOrderComponent implements OnInit {

  listaItensPedido: ItensPedido[] = [];
  displayedColumns = ['id', 'produto_id', 'quantidadeProduto', 'acoes' ];
  constructor(private itemOrder: ItemOrderService) { }



  ngOnInit() {
   this.itemOrder.getItensPedido()
   .subscribe(data => {
     this.listaItensPedido = data
   })
  }

}
