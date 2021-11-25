import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ItemOrderService {

  public ListaItensCarrinho : any =[];
  public productList = new BehaviorSubject<any>([]);
  
  constructor() { }

  getProducts(){
    return this.productList.asObservable();
  }

  addCarrinho(product : any){
    this.ListaItensCarrinho.push(product);
    this.productList.next(this.ListaItensCarrinho);
    this.getPrecoTotal();
    console.log(this.ListaItensCarrinho)
  }

  getPrecoTotal(){
    let valorTotal = 0;
    this.ListaItensCarrinho.map((a:any)=>{
      valorTotal += a.total;
    })
  }

  deleteItemCarrinho(product: any){
    this.ListaItensCarrinho.map((a:any, index:any)=>{
      if(product.id === a.id){
        this.ListaItensCarrinho.aplice(index,1);
      }
    })
  }

  deleteAllItemCarrinho(){
    this.ListaItensCarrinho = []
    this.productList.next(this.ListaItensCarrinho);
  }




//  urlBase = "http://localhost:8080/itensPedido"

//  getItensPedido(){
//    return this.http.get<ItensPedido[]>(this.urlBase);
//  }
  
  //criar metodo para adicionar os produtos - Byanca 

}
