import { Component, OnInit } from '@angular/core';
import { Endereco } from '../model/endereco';
import { EnderecoService } from '../services/endereco.service';
import { Router } from '@angular/router';
import { CepService } from '../services/cep.service';
import { Form } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-endereco',
  templateUrl: './endereco.component.html',
  styleUrls: ['./endereco.component.css'],
})

export class EnderecoComponent implements OnInit {
  endereco: Endereco = new Endereco();
  constructor(
    private enderecoService: EnderecoService,
    private router: Router,
    private cepService: CepService,
    private httpClient: HttpClient,
  ) {}

  ngOnInit(): void {}

  saveEndereco() {
    this.enderecoService.saveEndereco(this.endereco).subscribe((data) => {
      this.router.navigate(['/customerForm']);
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
    });
  }
}
