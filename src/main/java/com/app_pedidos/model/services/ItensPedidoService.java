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
import com.app_pedidos.model.dto.ItensPedidoDTO;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.repositories.ItensPedidoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@Service
public class ItensPedidoService {
	@Autowired
	private ItensPedidoRepository repository;
	
	@Transactional
	public ItensPedidoDTO insert(ItensPedidoDTO dto) {
	 	ItensPedido entity = new ItensPedido();
	 	entity.setQuantidadeProduto(dto.getQuantidadeProduto());
	 	entity.setProduto(dto.getProduto());
	 	entity.setPedido(dto.getPedido());
		
		entity = repository.save(entity);
		
		return new ItensPedidoDTO(entity);
	}
	
	public List<ItensPedidoDTO> findAll() {
		List<ItensPedido> list= repository.findAll();
		List<ItensPedidoDTO>listDto = new ArrayList<>();
		
		for(ItensPedido cob : list) {
			listDto.add(new ItensPedidoDTO(cob));
		}
		
		return listDto;
	}
	
	public ItensPedidoDTO findById(Long id) {
		Optional<ItensPedido>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		ItensPedido entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ItensPedidoDTO(entity);
	}
	
	@Transactional
	public ItensPedidoDTO update(Long id, ItensPedidoDTO dto) {
		try {
			ItensPedido entity = repository.getOne(id);
			entity.setQuantidadeProduto(dto.getQuantidadeProduto());
		 	entity.setProduto(dto.getProduto());
		 	entity.setPedido(dto.getPedido());
			
			entity = repository.save(entity);
			return new ItensPedidoDTO(entity);
			
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
