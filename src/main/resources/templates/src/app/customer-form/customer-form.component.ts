  import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../services/customer.service';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';
import { Endereco } from '../model/endereco';
import { EnderecoService } from './../services/endereco.service';



@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {


  endereco: Endereco[] = [];
  cliente$: Cliente[] = [];

  cliente: Cliente = new Cliente();

  constructor(private customerService: CustomerService, private router: Router, private enderecoService: EnderecoService) { }



  ngOnInit(): void {
    this.customerService.getClientes();
     this.enderecoService.getEnderecos()
     .subscribe(data => {
      this.endereco = data;
     console.log(data);
   })
         console.log(this.cliente);

   }

  saveCliente(){
    this.customerService.saveCliente(this.cliente)
    .subscribe(data => {
      this.router.navigate(['/customerList'])});
  }

}
