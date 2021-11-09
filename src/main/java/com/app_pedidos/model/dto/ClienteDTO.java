package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {
    private String nome;
    private String documento;

    public ClienteDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
