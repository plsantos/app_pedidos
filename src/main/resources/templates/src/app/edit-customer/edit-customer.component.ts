import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../services/customer.service';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css'],
})
export class EditCustomerComponent implements OnInit {
  cliente$: Cliente[] = [];

  cliente: Cliente = new Cliente();

  constructor(
    private customerService: CustomerService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.buscaCliente();

    console.log(this.cliente);
  }

  buscaCliente() {
    let idLocalStorage = localStorage.getItem('id');
    this.customerService.getCliente(idLocalStorage).subscribe((data) => {
      this.cliente = data;
    });
    console.log(this.cliente);
  }

  atualizar() {
    this.customerService.editCliente(this.cliente).subscribe((data) => {
      this.cliente = data;
      this.router.navigate(['customerList']);
      this.toastr.success('Cliente atualizado com sucesso!!');
    });
  }
}
