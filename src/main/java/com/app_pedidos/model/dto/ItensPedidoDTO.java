package com.app_pedidos.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.entity.Produto;

import lombok.Getter;

@Getter
public class ItensPedidoDTO {
    private int quantidadeProduto;
    private Produto produto;
    private Pedido pedido;

    public ItensPedidoDTO(ItensPedido itensPedido){
        this.quantidadeProduto = itensPedido.getQuantidadeProduto();
        this.produto = itensPedido.getProduto();
        this.pedido = itensPedido.getPedido();
    }

    public static List<ItensPedidoDTO> converter(List<ItensPedido> itensPedido){
        return itensPedido.stream().map(ItensPedidoDTO::new).collect(Collectors.toList());
    }
}
