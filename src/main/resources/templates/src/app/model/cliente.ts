//interface, usada apenas em tempo de desenvolvimento, não irá para produção
export class Cliente {
  id: String;
  nome: String;
  tipo: String;
  documento: String;
  endereco: String;

  constructor( id: String, nome: String, tipo: String, documento: String, endereco: String){
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.documento = documento;
    this.endereco = endereco;
}
}


