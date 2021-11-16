import { Cliente } from '../model/cliente';

export class Pedido {
  constructor(
    public id: number,
    public cliente: Cliente,
    public data: Date,
    public valorTotal: number,
    public situacao: boolean
  ) {}
}
