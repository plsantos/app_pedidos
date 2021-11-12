import { Component, OnInit } from '@angular/core';
import { Product } from './../model/product';
import { ProductService } from './../services/product.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  product$: Observable<Product[]>;
  displayedColumns = ['id', 'descricao', 'valorUnitario', 'status', 'acoes'];

 constructor(private productService: ProductService) {
   this.product$ = this.productService.findAll();

 }

 ngOnInit(): void {

 }


}
