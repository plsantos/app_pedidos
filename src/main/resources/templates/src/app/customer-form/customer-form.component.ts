import { Component, OnInit } from '@angular/core';
import { CustomerService } from './../services/customer.service';
import { Router } from '@angular/router';
import { Cliente } from '../model/cliente';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css'],
})
export class CustomerFormComponent implements OnInit {
  cliente$: Cliente[] = [];

  cliente: Cliente = new Cliente();

  constructor(
    private customerService: CustomerService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {}

  saveCliente() {
    this.customerService.saveCliente(this.cliente).subscribe((data) => {
      this.router.navigate(['/customerList']);
    });
    this.toastr.success('Cliente cadastrado com sucesso!');
  }
}
