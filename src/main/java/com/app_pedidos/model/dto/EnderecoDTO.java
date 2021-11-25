package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
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
        this.id = endereco.getId();
    }

    
}
