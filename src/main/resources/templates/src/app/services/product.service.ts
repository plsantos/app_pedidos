import { Injectable } from '@angular/core';
import { Product } from '../model/product';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private readonly API = '/assets/product.json';


  constructor(public httpClient: HttpClient) { }

  findAll(){
    return this.httpClient.get<Product[]>(this.API);
}
}
