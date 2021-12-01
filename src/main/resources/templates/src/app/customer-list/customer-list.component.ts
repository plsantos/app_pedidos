import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/cliente';
import { CustomerService } from './../services/customer.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
})
export class CustomerListComponent implements OnInit {
  cliente$: Cliente[] = [];
  displayedColumns = ['id', 'nome', 'tipo', 'documento', 'acoes'];

  constructor(
    private customerService: CustomerService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.buscarCliente();
  }

  buscarCliente() {
    this.customerService.getClientes().subscribe((data) => {
      this.cliente$ = data;
      console.log(data);
    });
  }

  deleteCliente(id: number): void {
    this.customerService.deleteCliente(id).subscribe({
      next: (data) => {
        this.buscarCliente();
        this.toastr.success('Cliente deletado com sucesso!');
      },
      error: (e) => {
        this.toastr.error(
          'Este cliente não pode ser deletado, pois está associado a algum pedido!'
        );
      },
    });
  }

  editar(id: any): void {
    localStorage.setItem('id', id.toString());
  }
}
