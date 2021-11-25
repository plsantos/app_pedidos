import { Component, OnInit } from '@angular/core';
import { ItemOrderService, CarrinhoItems } from '../../services/item-order.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']

})
export class HeaderComponent implements OnInit {

  public numberOfItems = 0;

  constructor(
    private itemOrderService: ItemOrderService
  ) { }

  ngOnInit(): void {
    this.itemOrderService.getProducts()
      .subscribe((data: CarrinhoItems) => {
        this.numberOfItems = data?.listaItensCarrinho?.length || 0;
      })
  }
}
