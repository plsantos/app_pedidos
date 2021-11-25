import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from '../model/produto';
import { ProductService } from './../services/product.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produto$: Produto[] = [];

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.productService.getProdutos().subscribe((data) => {
      this.produto$ = data;
      console.log(data);
    });
  }

  inserirCarrinho(): void {

  }

}
