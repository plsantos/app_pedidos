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
import com.app_pedidos.model.dto.PedidoDTO;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public void inativar(Long id) {
        Pedido pedidoInativo = repository.getById(id);
        pedidoInativo.setSituacao(false);
        repository.save(pedidoInativo);
    }
    
    @Transactional
	public PedidoDTO insert(PedidoDTO dto) {
    	Pedido entity = new Pedido();
		entity.setCliente(dto.getCliente());
		entity.setData(dto.getData());
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setCep(dto.getCep());
		entity.setSituacao(dto.isSituacao());
		entity = repository.save(entity);
		
		return new PedidoDTO(entity);
	}
    
    public List<PedidoDTO> findAll() {
		List<Pedido> list= repository.findAll();
		List<PedidoDTO>listDto = new ArrayList<>();
		
		for(Pedido cob : list) {
			listDto.add(new PedidoDTO(cob));
		}
		
		return listDto;
	}
    
    public PedidoDTO findById(Long id) {
		Optional<Pedido>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Pedido entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new PedidoDTO(entity);
	}
    
    @Transactional
	public PedidoDTO update(Long id, PedidoDTO dto) {
		try {
			Pedido entity = repository.getOne(id);
			if(entity.isSituacao()) {
				entity.setCliente(dto.getCliente());
				entity.setData(dto.getData());
				entity.setRua(dto.getRua());
				entity.setNumero(dto.getNumero());
				entity.setBairro(dto.getBairro());
				entity.setCidade(dto.getCidade());
				entity.setCep(dto.getCep());
				entity.setSituacao(dto.isSituacao());
				entity = repository.save(entity);
			}
			return new PedidoDTO(entity);
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
