package com.app_pedidos.model.services;

import com.app_pedidos.model.dto.ProdutoDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@Service // classe que concentra TODAS as regras de negocio
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

//    public void inativar(Long id) {
//        Produto produto = repository.getById(id);
//        for (Pedido pedido : repository.findAll()){
//            if(produto.getId() != pedido.getItensPedido().getProduto().getId())
//                produto.setStatus(false);
//        }
//        repository.save(produto);
//    }

	public Page<Produto> listAll(Pageable pageable){
		return repository.findAll(pageable);
	}
    @Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
    	Produto entity = new Produto();
		entity.setDescricao(dto.getDescricao());
		entity.setStatus(dto.isStatus());
		entity.setValor(dto.getValor());
		entity = repository.save(entity);
		
		return new ProdutoDTO(entity);
	}
    
    public List<ProdutoDTO> findAll() {
		List<Produto> list= repository.findAll();
		List<ProdutoDTO>listDto = new ArrayList<>();

		for(Produto cob : list) {
			listDto.add(new ProdutoDTO(cob));
		}

		return listDto;
	}
    
    public ProdutoDTO findById(Long id) {
		Optional<Produto>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Produto entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ProdutoDTO(entity);
	}
    
    @Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setStatus(dto.isStatus());
			entity.setValor(dto.getValor());
			entity = repository.save(entity);
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
			
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
