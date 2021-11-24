import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/cliente';
import { CustomerService } from './../services/customer.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
})
export class CustomerListComponent implements OnInit {


  cliente$: Cliente[] = [];
  displayedColumns = ['id', 'nome', 'tipo', 'documento', 'endereco', 'acoes'];

  constructor(private customerService: CustomerService) {
    //this.customer$ = this.customerService.findAll();
  }

  ngOnInit(): void {
    this.customerService.getClientes().subscribe((data) => {
      this.cliente$ = data;
      console.log(data);
    });
  }

  deleteCliente(id: number): void {
    this.customerService.deleteCliente(id).subscribe();
    this.cliente$ = this.cliente$.filter((p) => p.id != id);
  }
}
