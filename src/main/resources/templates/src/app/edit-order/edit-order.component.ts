import { Component, OnInit } from '@angular/core';
import { OrderService } from './../services/order.service';
import { Router } from '@angular/router';
import { Pedido } from '../model/pedido';
import { Cliente } from '../model/cliente';



@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {

  cliente: Cliente[] = [];

  pedido$: Pedido[] = [];

  pedido: Pedido = new Pedido();

  constructor(private orderService: OrderService, private router: Router) { }


  ngOnInit(): void {

     this.buscaPedido();

   console.log(this.pedido);

   }

   buscaPedido(){
    let idLocalStorage = localStorage.getItem("id");
        this.orderService.getPedido(idLocalStorage).subscribe(data =>{
          this.pedido = data;
         });
         console.log(this.pedido);
    }

    atualizar(){
      this.orderService.editPedido(this.pedido)
      .subscribe(data =>{
        this.pedido = data;
        this.router.navigate(['orderList'])
      })
    }}
