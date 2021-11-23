export class ItensPedido{
    id: number;
    produto_id: number;
    quantidadeProduto: number;

    constructor(id: number, produto_id: number, quantidadeProduto: number){
        this.id = id;
        this.produto_id = produto_id;
        this.quantidadeProduto = quantidadeProduto;
    }
}