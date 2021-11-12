export class Produto {
  id:number;
  descricao: String;
  valor: number;
  status: boolean;

  constructor(id:number,  descricao: String, valor: number, status: boolean){
            this.id = id;
            this.descricao = descricao;
            this.valor = valor;
            this.status = status;
    }
  }

