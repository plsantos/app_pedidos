export class Endereco {
  id: String;
  rua: String;
  numero: number;
  bairro: string;
  cidade: String;
  cep: String;

  constructor(id: String, rua: String, numero: number, bairro: string, cidade: String, cep: String){
    this.id = id;
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.cep = cep;
  }
}

