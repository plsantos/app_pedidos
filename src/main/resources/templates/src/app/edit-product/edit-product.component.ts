import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Produto } from '../model/produto';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css'],
})
export class EditProductComponent implements OnInit {
  produto$: Produto[] = [];

  produto: Produto = new Produto();

  constructor(private productService: ProductService, private router: Router) {}

  status = ['True', 'False'];

  ngOnInit(): void {
    this.buscaProduto();

    console.log(this.produto);
  }

  buscaProduto() {
    let idLocalStorage = localStorage.getItem('id');
    this.productService.getProduto(idLocalStorage).subscribe((data) => {
      this.produto = data;
    });
    console.log(this.produto);
  }

  atualizar() {
    this.productService.editProduto(this.produto).subscribe((data) => {
      this.produto = data;
      this.router.navigate(['productList']);
      alert('Produto atualizado com sucesso!!');
    });
  }
}
