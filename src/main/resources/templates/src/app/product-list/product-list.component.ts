import { Component, OnInit } from '@angular/core';
import { Produto } from '../model/produto';
import { ProductService } from './../services/product.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  produto$: Produto[] = [];
  // Observable<Product[]>;
  displayedColumns = ['id', 'descricao', 'valor', 'status', 'acoes'];

 constructor(private productService: ProductService, private router: Router) {
  // this.product$ = this.productService.findAll();

 }


 ngOnInit(): void {
  this.productService.getProdutos()
   .subscribe(data => {
    this.produto$ = data;
    console.log(data);

 })
 }
}
