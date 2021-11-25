import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../services/customer.service';
import { Router } from '@angular/router';

import { Cliente } from '../model/cliente';


@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  cliente$: Cliente[] = [];

  cliente: Cliente = new Cliente();

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {

  }

  saveCliente(){
    this.customerService.saveCliente(this.cliente)
    .subscribe(data => {
      this.router.navigate(['/customerList'])});
  }

}
