//interface, usada apenas em tempo de desenvolvimento, não irá para produção
import { Endereco } from '../model/endereco';

export class Cliente {
  constructor(
    public id: String,
    public nome: String,
    public tipo: String,
    public documento: String,
    public endereco: Endereco
  ) {}
}
