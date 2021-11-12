import { Injectable } from '@angular/core';
import { Pedido } from '../model/pedido';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  private readonly API = '/assets/order.json';


  constructor(public httpClient: HttpClient) { }

  findAll(){
    return this.httpClient.get<Pedido[]>(this.API);
  }
}
