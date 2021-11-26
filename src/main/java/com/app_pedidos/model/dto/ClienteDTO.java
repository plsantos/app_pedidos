package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tipo;
	private String documento;
	private String nome;
	
	
	public ClienteDTO(Cliente entity) {
		this.id= entity.getId();
		this.tipo=entity.getTipo();
		this.documento=entity.getDocumento();
		this.nome=entity.getNome();
	}

		
	
}

