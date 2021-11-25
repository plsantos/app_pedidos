import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from '../model/produto';
import { ProductService } from './../services/product.service';
import { ItemOrderService } from './../services/item-order.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit,OnChanges {
  url='http://localhost:8080/produto/pageable?size=3';
  public totalItens: number = 0;
  produto$: Produto[] = [];
  paginasBotoes: number[] = [];
  page : number =0;

  constructor(
    private productService: ProductService,
    private itemOrderService: ItemOrderService,
    private router: Router,
    private http: HttpClient
  ) {}
  ngOnChanges(changes: SimpleChanges): void {
    this.getProdutos(this.page.toString());
  }


  ngOnInit(): void {
    this.productService.getProdutos().subscribe((data) => {
      this.totalItens = data.length;
      this.produto$ = data.slice(0,3);
      console.log('Produtos ===>', data);

      this.getTotalPaginas();
      this.productService.getTotalPaginas().subscribe(obj => {
       this.paginasBotoes= [];
        this.totalItens = obj;
        for(let i=0; i< obj; i++){
          this.paginasBotoes.push(i);
        }
      })
  };


  getTotalPaginas(): Observable<any>{
    return this.http.get(this.url + "totaldepaginas");
  }
}
