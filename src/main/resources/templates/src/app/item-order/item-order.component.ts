import { Component, OnInit } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';
import { ItemOrderService } from '../services/item-order.service';
import { Produto } from '../model/produto';
//import { Guid } from 'guid-typescript';
//import { FaChechCircle } from '@fortawesome/free-solid-svg-icons';
import { FormGroup, FormControl } from '@angular/forms';



@Component({
  selector: 'app-item-order',
  templateUrl: './item-order.component.html',
  styleUrls: ['./item-order.component.css']
})
export class ItemOrderComponent implements OnInit {

  listaItensPedido: ItensPedido[] = [];
  displayedColumns = ['id', 'idPedido', 'idProduto', 'quantidade', 'acoes' ];
  constructor(private itemOrder: ItemOrderService) { }



  ngOnInit() {
   this.itemOrder.getItensPedido()
   .subscribe(data => {
     this.listaItensPedido = data
   })
  }

}
