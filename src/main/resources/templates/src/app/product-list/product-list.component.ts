import { Component, OnInit } from '@angular/core';
import { Produto } from '../model/produto';
import { ProductService } from './../services/product.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ProductService],
})
export class ProductListComponent implements OnInit {
  produto$: Produto[] = [];
  // Observable<Product[]>;
  displayedColumns = ['id', 'descricao', 'valor', 'status', 'acoes'];


  produtoSelecionado = Produto;

  constructor(
    private productService: ProductService,
    private router: Router,
    private service: ProductService
  ) { }

  ngOnInit(): void {
    this.productService.getProdutos().subscribe((data) => {
      this.produto$ = data.content;
      console.log(data);
    });
  }

  deleteProduto(id: number): void {
    this.productService.deleteProduto(id).subscribe();
    this.produto$ = this.produto$.filter((p) => p.id != id);
  }

  editar(id: any): void {
    localStorage.setItem("id", id.toString());
  }
}
