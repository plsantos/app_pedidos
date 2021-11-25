package com.app_pedidos.model.dto;

import java.io.Serializable;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private int quantidadeProduto;
    private Produto produto;
    private Pedido pedido;

    public ItensPedidoDTO(ItensPedido itensPedido){
        this.quantidadeProduto = itensPedido.getQuantidadeProduto();
        this.produto = itensPedido.getProduto();
        this.pedido = itensPedido.getPedido();
        this.id = itensPedido.getId();
    }

    
}
