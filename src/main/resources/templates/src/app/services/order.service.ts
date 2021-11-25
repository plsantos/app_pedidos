import { Injectable } from '@angular/core';
import { Pedido } from '../model/pedido';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public pedidoId = new BehaviorSubject<number>(-1);

  constructor(private http: HttpClient) { }

  Url = 'http://localhost:8080/pedido';

  getPedidos(): Observable<any> {
    return this.http.get<Pedido[]>(this.Url);
  }

  getPedido(id: number): Observable<any> {
    return this.http.get<Pedido>(this.Url + id);
  }

  savePedido(pedido: Pedido): Observable<any> {
    return this.http.post<Pedido>(this.Url, pedido);
  }

  editPedido(id: number, pedido: Pedido): Observable<any> {
    return this.http.put(this.Url + id, pedido);
  }

  deletePedido(id: number): Observable<any> {
    return this.http.delete<Pedido>(`${this.Url}/${id}`);
  }
}


