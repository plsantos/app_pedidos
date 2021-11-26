import { Component, OnInit } from '@angular/core';
import { OrderService } from './../services/order.service';
import { Router } from '@angular/router';
import { Pedido } from '../model/pedido';
import { Cliente } from '../model/cliente';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css'],
})
export class EditOrderComponent implements OnInit {
  cliente: Cliente[] = [];

  pedido$: Pedido[] = [];

  pedido: Pedido = new Pedido();

  constructor(
    private orderService: OrderService,
    private router: Router,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.buscaPedido();

    console.log(this.pedido);
  }

  buscaPedido() {
    let idLocalStorage = localStorage.getItem('id');
    this.orderService.getPedido(idLocalStorage).subscribe((data) => {
      this.pedido = data;
      console.log('buscaPedido()', this.pedido);
    });
  }

  atualizar() {
    this.orderService.editPedidos(this.pedido).subscribe((data) => {
      this.pedido = data;
      this.router.navigate(['orderList']);
      alert("Atualização salva com sucesso!");
    });
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
}
