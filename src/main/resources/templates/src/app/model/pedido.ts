import { Cliente } from '../model/cliente';

export class Pedido {
  constructor(
    public id?: number,
    idCliente?: number | undefined,
    public data?: Date,
    public situacao?: boolean,
    public valorTotal?: number,
    public rua?: String,
    public numero?: number,
    public bairro?: string,
    public cidade?: String,
    public estado?: String,
    public cep?: String,
    public descontos?: number
  ) { }
}
