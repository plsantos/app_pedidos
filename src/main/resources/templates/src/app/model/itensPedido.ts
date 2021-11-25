import { Endereco } from "./endereco";

export class ItensPedido{
    id: number;
    produto_id: number;
    quantidadeProduto: number;

    constructor(id: number, produto_id: number, quantidadeProduto: number, public endereco?: Endereco){
        this.id = id;
        this.produto_id = produto_id;
        this.quantidadeProduto = quantidadeProduto;
        this.endereco = endereco;
    }
}