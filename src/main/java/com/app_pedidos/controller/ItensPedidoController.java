package com.app_pedidos.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_pedidos.model.dto.ItensPedidoDTO;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.ItensPedidoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/itensPedido")
public class ItensPedidoController {
	@Autowired // injetando
	private ItensPedidoRepository repository;

	@PostMapping
	public void save(@RequestBody ItensPedido itensPedido) {
		if(itensPedido.getProduto().isStatus())
			repository.save(itensPedido);
	}

	@GetMapping
	public List<ItensPedidoDTO> findAll() {
		List<ItensPedido> itensLista = repository.findAll();
		return ItensPedidoDTO.converter(itensLista);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
	}
	
	@PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ItensPedido itensPedido) {
		try {
			ItensPedido itensPedidoPesquisado = repository.getOne(id);
	        if (itensPedidoPesquisado != null) {
	        	itensPedidoPesquisado.setQuantidadeProduto(itensPedido.getQuantidadeProduto());
	        	itensPedidoPesquisado.setProduto(itensPedido.getProduto());
	            repository.save(itensPedidoPesquisado);
	        }
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
    }
}
