package com.app_pedidos.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

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

	public List<EnderecoDTO> findAll() {
		List<Endereco> list= repository.findAll();
		List<EnderecoDTO>listDto = new ArrayList<>();
		
		for(Endereco cob : list) {
			listDto.add(new EnderecoDTO(cob));
		}
		
		return listDto;
	}

	public EnderecoDTO findById(Long id) {
		Optional<Endereco>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Endereco entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new EnderecoDTO(entity);
	}
	
	@Transactional
	public EnderecoDTO update(Long id, EnderecoDTO dto) {
		try {
			Endereco entity = repository.getOne(id);
			entity.setBairro(dto.getBairro());
			entity.setCep(dto.getCep());
			entity.setCidade(dto.getCidade());
			entity.setNumero(dto.getNumero());
			entity.setRua(dto.getRua());
			entity = repository.save(entity);
			return new EnderecoDTO(entity);
			
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
		
	}
}
