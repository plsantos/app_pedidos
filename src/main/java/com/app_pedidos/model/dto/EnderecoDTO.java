package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Endereco;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public EnderecoDTO(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
    }

    public static List<EnderecoDTO> converter(List<Endereco> enderecos){
        return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }
}
