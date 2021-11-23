import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Endereco } from '../model/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  constructor(private http:HttpClient) {}

  Url='http://localhost:8080/endereco';

   saveEndereco(endereco: Endereco): Observable<any>{
    return this.http.post<Endereco>(this.Url, endereco);
  }

  editEndereco(id: number, endereco: Endereco): Observable<any>{
    return this.http.put(this.Url + id, endereco);
  }

  deleteEndereco(id: number): Observable<any>{
    return this.http.delete<Endereco>(`${this.Url}/${id}`);
  }

}