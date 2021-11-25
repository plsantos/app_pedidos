//package com.app_pedidos.tests.factory;
//
//import com.app_pedidos.model.entity.Cliente;
//import com.app_pedidos.model.entity.Pedido;
//
//import java.time.LocalDate;
//
//public class PedidoFactory {
//    public static Pedido createPedido(){
//        Cliente cliente = ClienteFactory.createCliente();
//        LocalDate data = LocalDate.now();
//        return new Pedido(1, data, cliente, true, "Rua", "Bairro", "Cidade", "Estado","123", 80.0);
//    }
//}
