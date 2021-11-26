import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from './../services/product.service';
import { Produto } from '../model/produto';
import { ItemOrderService } from './../services/item-order.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  url = 'http://localhost:8080/endereco';
  produto$: Produto[] = [];

  constructor(
    private productService: ProductService,
    private itemOrderService: ItemOrderService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.productService.getProdutos().subscribe((data) => {
      this.produto$ = data.slice(0, 3);
      console.log('Produtos ===>', data);
    });
  }

  inserirCarrinho(product: Produto): void {
    this.itemOrderService.addCarrinho(product);
  }

  getTotalPaginas(): Observable<any> {
    return this.http.get(this.url + 'totaldepaginas');
  }
}
