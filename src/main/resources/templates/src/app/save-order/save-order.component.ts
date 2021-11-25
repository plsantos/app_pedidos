import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';
import { Pedido } from '../model/pedido';
import { CustomerService } from '../services/customer.service';
import { OrderService } from '../services/order.service';
import { ItemOrderService, CarrinhoItems } from '../services/item-order.service';

@Component({
  selector: 'app-save-order',
  templateUrl: './save-order.component.html',
  styleUrls: ['./save-order.component.css'],
})
export class SaveOrderComponent implements OnInit {
  cliente$: Cliente[] = [];
  carrinho: CarrinhoItems = { idPedido: 0, listaItensCarrinho: [] };

  pedido: Pedido = new Pedido();

  pedido_data: Pedido[] = [];

  constructor(
    private orderService: OrderService,
    private router: Router,
    private httpClient: HttpClient,
    private customerService: CustomerService,
    private itemOrder: ItemOrderService

  ) { }

  ngOnInit(): void {
    this.customerService.getClientes()
      .subscribe(data => {
        this.cliente$ = data;
        console.log(data);
      })
    console.log(this.cliente$);

    this.itemOrder.getProducts()
      .subscribe((data: CarrinhoItems) => {
        this.carrinho = data;
        this.pedido.valorTotal = data?.listaItensCarrinho?.map((item) => item.valor).
          reduce((acc, valor) => (acc || 0) + (valor || 0), 0)

        console.log('aqui', this.pedido)
      })
  }

  savePedido() {
    this.orderService.savePedido(this.pedido).subscribe((data) => {
      this.router.navigate(['/orderList']);
    });
    console.log(this.pedido);
  }

  consultaCep(valor: any, formGroup: any) {
    valor = valor.replace(/\D/g, '');

    if (valor != '') {
      //   Expressão regular para validar o CEP.
      var validacep = /^[0-9]{8}$/;

      //     Valida o formato do CEP.
      if (validacep.test(valor)) {
        this.httpClient
          .get(`https://viacep.com.br/ws/${valor}/json/`)
          .subscribe((dados) => this.populaForm(dados, formGroup));
      } else {
        //cep é inválido.
        alert(
          'Formato de CEP inválido!\nPor favor digite um cep com 9 dígitos numéricos.'
        );
      }
    }
  }

  populaForm(dados: any, formGroup: any) {
    formGroup.setValue({
      cep: dados.cep,
      rua: dados.logradouro,
      numero: '',
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf,
    });
  }

  valorDesconto(value: any) {
    this.pedido.descontos = (this.pedido.valorTotal || 0) - ((this.pedido.valorTotal || 0) * value / 100);
  }

}
