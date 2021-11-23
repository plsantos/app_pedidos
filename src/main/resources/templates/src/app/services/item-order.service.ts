import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ItensPedido } from '../model/itensPedido';

@Injectable({
  providedIn: 'root'
})
export class ItemOrderService {

  constructor(private http: HttpClient) { }

  urlBase = "http://localhost:8080/itensPedido"

  getItensPedido(){
    return this.http.get<ItensPedido[]>(this.urlBase);
  }
  
  //criar metodo para adicionar os produtos - Byanca 

}
