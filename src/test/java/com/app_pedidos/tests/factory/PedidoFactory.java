package com.app_pedidos.tests.factory;

import com.app_pedidos.model.dto.PedidoDTO;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.Pedido;

import java.time.LocalDate;

public class PedidoFactory {
   public static Pedido createPedido(){
       Cliente cliente = ClienteFactory.createCliente();
       LocalDate data = LocalDate.now();
          
       return new Pedido(null,data,cliente,true,"Rua","123","bairro","cidade","estado","cep",800);
   }
   public static PedidoDTO createPedidoDTO() {
		return new PedidoDTO(createPedido());
	}
}