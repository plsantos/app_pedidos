import { Component, OnInit } from '@angular/core';
import { Endereco } from '../model/endereco';
import { EnderecoService } from '../services/endereco.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-endereco',
  templateUrl: './endereco.component.html',
  styleUrls: ['./endereco.component.css']
})

export class EnderecoComponent implements OnInit {

  endereco: Endereco = new Endereco();
  constructor(private enderecoService: EnderecoService, private router: Router) { }

  ngOnInit(): void {
  }

  saveEndereco(){
    this.enderecoService.saveEndereco(this.endereco)
    .subscribe(data => {
      this.router.navigate(['/customerForm'])});
  }

}
