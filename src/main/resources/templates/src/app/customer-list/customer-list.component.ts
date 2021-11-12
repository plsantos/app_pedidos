import { Component, OnInit } from '@angular/core';
import { Customer } from './../model/customer';
import { CustomerService } from './../services/customer.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {

  customer$: Observable<Customer[]>;
   displayedColumns = ['id', 'nome', 'tipo', 'documento', 'endereco', 'acoes'];

  constructor(private customerService: CustomerService) {
    this.customer$ = this.customerService.findAll();

  }

  ngOnInit(): void { /**caso precise que algo seja iniciado apenas na hora q o componente é inicializado no HTML*/

  }

}
