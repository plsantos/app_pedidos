import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../model/cliente';


@Injectable({ //necessário para utlização da injeção de dependência
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http:HttpClient) {}

  Url='http://localhost:8080/cliente';

  getClientes(): Observable<any>{
    return this.http.get<Cliente[]>(this.Url);
  }

  getCliente(id: string): Observable<any>{
    return this.http.get<Cliente>(this.Url + id);
  }

  saveCliente(cliente: Cliente): Observable<any>{
    return this.http.post<Cliente>(this.Url, cliente);
  }

  editCliente(id: String, cliente: Cliente): Observable<any>{
    return this.http.put(this.Url + id, cliente);
  }

  deleteCliente(id: String): Observable<any>{
    return this.http.delete(this.Url + id);
  }

}
