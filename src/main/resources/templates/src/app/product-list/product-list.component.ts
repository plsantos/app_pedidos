import { Component, OnInit } from '@angular/core';
import { Produto } from '../model/produto';
import { ProductService } from './../services/product.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

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
    private service: ProductService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.buscarProduto();
  }

  buscarProduto() {
    this.productService.getProdutos().subscribe((data) => {
      this.produto$ = data;
      console.log(data);
    });
  }
  deleteProduto(id: number): void {
    this.productService.deleteProduto(id).subscribe({
      next: (data) => {
        this.buscarProduto();
        this.toastr.success('Produto deletado com sucesso!');
      },
      error: (e) => {
        this.toastr.error(
          'Este produto não pode ser deletado, pois está associado a algum pedido!'
        );
      },
    });
  }

  editar(id: any): void {
    localStorage.setItem('id', id.toString());
  }
}
