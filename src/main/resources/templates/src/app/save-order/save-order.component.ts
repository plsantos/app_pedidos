import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Cliente } from '../model/cliente';
import { Pedido } from '../model/pedido';
import { CustomerService } from '../services/customer.service';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-save-order',
  templateUrl: './save-order.component.html',
  styleUrls: ['./save-order.component.css']
})
export class SaveOrderComponent implements OnInit {

  cliente$: Cliente[] = [];

  pedido: Pedido = new Pedido();

  pedido_data: Pedido[] = [];

  constructor(
    private orderService: OrderService,
    private router: Router,
    private httpClient: HttpClient,
    private customerService: CustomerService

  ) { }

  ngOnInit(): void {
    this.customerService.getClientes()
     .subscribe(data => {
      this.cliente$ = data;
     console.log(data);
   })
         console.log(this.cliente$);
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
    });
  }

  // valorDesconto (value: any){
  //   if (value = 10){
  //     this.pedido.valor -= this.pedido.valor*0.10;

  //   }

  // }


}
