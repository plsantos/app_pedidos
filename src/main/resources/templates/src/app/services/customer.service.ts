import { Customer } from './../model/customer';
import { HttpClient } from '@angular/common/http';
import { TagPlaceholder } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';

@Injectable({ //necessário para utlização da injeção de dependência
  providedIn: 'root'
})
export class CustomerService {

  private readonly API = '/assets/customer.json'; //endpoint do servidor depois apontar para o spring aqui


  constructor(public httpClient: HttpClient) { } //injeção dependência instância do httpClient

  findAll(){
    return this.httpClient.get<Customer[]>(this.API); //retorna um observable de objeto
}
}
