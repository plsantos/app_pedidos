import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Produto } from '../model/produto';
import { OrderService } from './../services/order.service';


export interface CarrinhoItems {
  idPedido?: number,
  listaItensCarrinho: Produto[]
}

@Injectable({
  providedIn: 'root'
})

export class ItemOrderService {

  public Carrinho: any = {
    idPedido: 0,
    listaItensCarrinho: []
  };
  public productList = new BehaviorSubject<any>([]);

  constructor(
    private orderService: OrderService,
  ) { }

  getProducts() {
    return this.productList.asObservable();
  }

  addCarrinho(product: Produto) {
    if (!this.Carrinho.listaItensCarrinho.length) {
      this.orderService.savePedido({}).subscribe((data) => {
        console.log('pedido criação ===> ', data)
        this.Carrinho.idPedido = data.id;
      })
    }
    this.Carrinho.listaItensCarrinho.push(product);
    this.productList.next(this.Carrinho);
    this.getPrecoTotal();
    console.log(this.Carrinho.listaItensCarrinho)
  }

  getPrecoTotal() {
    let valorTotal = 0;
    this.Carrinho.listaItensCarrinho.map((a: any) => {
      valorTotal += a.total;
    })
  }

  deleteItemCarrinho(product: any) {
    this.Carrinho.listaItensCarrinho.map((a: any, index: any) => {
      if (product.id === a.id) {
        this.Carrinho.listaItensCarrinho.aplice(index, 1);
      }
    })
  }

  deleteAllItemCarrinho() {
    this.Carrinho.listaItensCarrinho = []
    this.productList.next(this.Carrinho.listaItensCarrinho);
  }
}
