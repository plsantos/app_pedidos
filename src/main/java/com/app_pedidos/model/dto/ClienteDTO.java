package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.Endereco;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteDTO {
    private String tipo;
    private String nome;
    private String documento;
    private Endereco endereco;

    public ClienteDTO(Cliente cliente){
        this.tipo = cliente.getTipo();
        this.nome = cliente.getNome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
}
