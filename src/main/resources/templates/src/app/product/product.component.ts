import { Component, OnInit } from '@angular/core';
import { ItemOrderService } from '../services/item-order.service';
import { ProductService } from './../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productList : any;
  constructor(private product : ProductService, private CartItem: ItemOrderService) { }

  ngOnInit(): void {
    this.product.getProdutos()
    .subscribe(res=>{
      this.productList = res;

      this.productList.forEach((a:any) => {
        Object.assign(a,{quantidade:1,total:a.preco});
      });
    })
  }

  addParaCarrinho(item: any){
    this.CartItem.addCarrinho(item)
  }

}
