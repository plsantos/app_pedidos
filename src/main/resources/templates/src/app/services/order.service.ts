import { Injectable } from '@angular/core';
import { Order } from '../model/order';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  private readonly API = '/assets/order.json';


  constructor(public httpClient: HttpClient) { }

  findAll(){
    return this.httpClient.get<Order[]>(this.API);
  }
}
