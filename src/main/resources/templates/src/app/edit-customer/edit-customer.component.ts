import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../services/customer.service';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';
import { Endereco } from '../model/endereco';
import { EnderecoService } from './../services/endereco.service';



@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {



  endereco: Endereco[] = [];
  cliente$: Cliente[] = [];

  cliente: Cliente = new Cliente();

  constructor(private customerService: CustomerService, private router: Router, private enderecoService: EnderecoService) { }


  ngOnInit(): void {
     this.enderecoService.getEnderecos()
     .subscribe(data => {
      this.endereco = data;
     console.log(data);
   })
   this.buscaCliente();

   console.log(this.cliente);

   }

   buscaCliente(){
    let idLocalStorage = localStorage.getItem("id");
        this.customerService.getCliente(idLocalStorage).subscribe(data =>{
          this.cliente = data;
         });
         console.log(this.cliente);
    }

    atualizar(){
      this.customerService.editCliente(this.cliente)
      .subscribe(data =>{
        this.cliente = data;
        this.router.navigate(['customerList'])
      })
    }
}
