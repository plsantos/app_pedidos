import { Cliente } from '../model/cliente';

export class Pedido {
  constructor(
    public id?: number,
    public cliente?: Cliente,
    public data?: Date,
    public situacao?: boolean,
    public valorTotal?: number,
    public rua?: String,
    public numero?: number,
    public bairro?: string,
    public cidade?: String,
    public cep?: String,
    public estado?: String,
    public descontos?: number

  ) {}
}
