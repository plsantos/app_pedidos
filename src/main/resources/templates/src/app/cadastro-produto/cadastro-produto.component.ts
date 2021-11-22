import { Component, OnInit } from '@angular/core';
import {ThemePalette} from '@angular/material/core';
import { Produto } from '../model/produto';

export interface Task {
  name: string;
  completed: boolean;
  color: ThemePalette;
  subtasks?: Task[];
}

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})

export class CadastroProdutoComponent implements OnInit {
  produto: Produto = new Produto();

   constructor(
     private descricao: ProdutoDescricao,
     private router: Router,
     private valor: ProdutoValor,
     
   ) { }

  ngOnInit(): void {
  }

}
