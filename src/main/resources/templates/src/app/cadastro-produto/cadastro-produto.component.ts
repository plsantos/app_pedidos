import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Produto } from '../model/produto';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})

export class CadastroProdutoComponent implements OnInit {
  produto: Produto = new Produto();
  status = ['True', 'False']
  submitted = false;

   constructor(
     private productService: ProductService,
     private router: Router,
     private httpClient: HttpClient
   ) { }

  ngOnInit(): void {
  }

  saveProduto() {
    this.productService.saveProduto(this.produto).subscribe((data) => {
      this.router.navigate(['/productList']);
    });
  }

  onSubmit() { this.submitted = true; }

}
