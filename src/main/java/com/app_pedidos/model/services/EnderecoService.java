package com.app_pedidos.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
    private EnderecoRepository repository;
	
	@Transactional
	public EnderecoDTO insert(EnderecoDTO dto) {
		Endereco entity = new Endereco();
		entity.setBairro(dto.getBairro());
		entity.setCep(dto.getCep());
		entity.setCidade(dto.getCidade());
		entity.setNumero(dto.getNumero());
		entity.setRua(dto.getRua());
		entity = repository.save(entity);
		
		return new EnderecoDTO(entity);
	}

}
