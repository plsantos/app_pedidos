import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from './../services/product.service';
import { Produto } from '../model/produto';
import { ItemOrderService } from './../services/item-order.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produto$: Produto[] = [];

  constructor(
    private productService: ProductService,
    private itemOrderService: ItemOrderService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.productService.getProdutos().subscribe((data) => {
      this.produto$ = data.slice(0, 3);
      console.log('Produtos ===>', data);
    });
  }

  inserirCarrinho(product: Produto): void {
    this.itemOrderService.addCarrinho(product)
  }

}
