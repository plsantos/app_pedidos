package com.app_pedidos.tests.factory;

import com.app_pedidos.model.dto.ItensPedidoDTO;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.entity.Produto;


public class ItensPedidoFactory {
	public static  ItensPedido createItensPedido(){
		Produto produto = ProdutoFactory.createProduct();
		Pedido pedido = PedidoFactory.createPedido();
		   
		return new ItensPedido(null,2,produto,pedido,4);
	}
	public static ItensPedidoDTO createItensPedidoDTO() {
		return new ItensPedidoDTO(createItensPedido());
	}

}
