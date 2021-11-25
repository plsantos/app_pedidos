import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  Url = 'http://localhost:8080/produto';

  getProdutos(): Observable<any> {
    return this.http.get<Produto[]>(this.Url);
  }

  getProduto(id: any): Observable<any> {
    return this.http.get<Produto>(this.Url+'/'+ id);
  }

  saveProduto(produto: Produto): Observable<any> {
    return this.http.post<Produto>(this.Url, produto);
  }

  editProduto(produto: Produto): Observable<any> {
    return this.http.put(this.Url +'/'+ produto.id, produto);
  }

  deleteProduto(id: number): Observable<any> {
    return this.http.delete<Produto>(`${this.Url}/${id}`);
  }

  getTotalPaginas(): Observable<any>{
    return this.http.get(this.Url + "totaldepaginas");
  }

  listarProdutos(page: string){
    return this.http.get<Produto[]>(this.Url + "pageable?page=" + page + "&size=10");
  }
}
