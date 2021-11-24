package com.app_pedidos.tests.factory;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;

public class EnderecoFactory {
    public static Endereco createEndereco() {
        return new Endereco(null, "rua", "123", "bairro", "cidade", "108860");
    }

    public static EnderecoDTO createEnderecoDTO() {
        return new EnderecoDTO(createEndereco());
    }
}
