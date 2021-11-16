// import { Injectable } from '@angular/core';
// import { Product } from '../model/product';
// import { HttpClient } from '@angular/common/http';


// @Injectable({
//   providedIn: 'root'
// })
// export class ProductService {


//   private readonly API = '/assets/product.json';


//   constructor(public httpClient: HttpClient) { }

//   findAll(){
//     return this.httpClient.get<Product[]>(this.API);
// }
// }

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) {}

  Url='http://localhost:8080/produto';

  getProdutos(): Observable<any>{
    return this.http.get<Produto[]>(this.Url);
  }

  getProduto(id: string): Observable<any>{
    return this.http.get<Produto>(this.Url + id);
  }

  saveProduto(produto: Produto): Observable<any>{
    return this.http.post<Produto>(this.Url, produto);
  }

  editProduto(id: String, produto: Produto): Observable<any>{
    return this.http.put(this.Url + id, produto);
  }

  deleteProduto(id: String): Observable<any>{
    return this.http.delete(this.Url + id);
  }

}
