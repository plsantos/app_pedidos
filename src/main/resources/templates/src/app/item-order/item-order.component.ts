import { Component, OnInit } from '@angular/core';
import { Carrinho } from '../model/carrinho';
import {
  ItemOrderService,
  CarrinhoItems,
} from '../services/item-order.service';
import { DataSource } from '@angular/cdk/collections';

@Component({
  selector: 'app-item-order',
  templateUrl: './item-order.component.html',
  styleUrls: ['./item-order.component.css'],
})
export class ItemOrderComponent implements OnInit {
  listaItensPedido: Carrinho[] = [];
  listProducts: Carrinho[] = [];
  displayedColumns = ['descricao', 'valor', 'status', 'valor-total', 'acoes'];
  dataSource: any;

  constructor(private itemOrder: ItemOrderService) {}

  ngOnInit() {
    this.itemOrder.getProducts().subscribe((data: CarrinhoItems) => {
      if (data.listaItensCarrinho) {
        data.listaItensCarrinho.forEach((item) => {
          const index = this.listProducts.findIndex(
            (findItem) => findItem.id === item.id
          );
          if (index != -1) {
            const quantidade = (this.listProducts[index].quantidade || 0) + 1;
            this.listProducts[index] = {
              descricao: item.descricao,
              total: quantidade * (item.valor || 0),
              quantidade,
              valor: item.valor,
              id: item.id,
            };
          } else {
            this.listProducts.push({
              descricao: item.descricao,
              total: item.valor,
              quantidade: 1,
              valor: item.valor,
              id: item.id,
            });
          }
        });
      }

      this.listaItensPedido = this.listProducts;
    });
  }
}

