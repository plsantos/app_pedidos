export class ItensPedido{
    id: number;
    idPedido: number;
    idProduto: number;
    quantidade: number;
    valorTotal: number;

    constructor(id: number, idPedido: number, idProduto: number, quantidade: number, valorTotal: number){
        this.id = id;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }
}