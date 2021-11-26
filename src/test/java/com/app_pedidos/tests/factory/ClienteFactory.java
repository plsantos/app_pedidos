package com.app_pedidos.tests.factory;

import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.entity.Cliente;

public class ClienteFactory {
    public static Cliente createCliente(){
        return new Cliente(null, "pf", "123.456.789-00","teste");
    }
    public static ClienteDTO createClienteDTO(){
        return new ClienteDTO(createCliente());
    }
}
