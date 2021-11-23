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

import com.app_pedidos.model.dto.ProdutoDTO;
import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<ProdutoDTO> findAll(){
        List<Produto> produtosLista = repository.findAll();
        return ProdutoDTO.converter(produtosLista);
    }

    @PostMapping
    public void save(@RequestBody Produto produto){
        repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
       try {
        	repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto){
    	try {
    		Produto produtoPesquisado = repository.getOne(id);
            if (produtoPesquisado != null){
                produtoPesquisado.setDescricao(produto.getDescricao());
                repository.save(produtoPesquisado);
            }
    	}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
        
    }
}
