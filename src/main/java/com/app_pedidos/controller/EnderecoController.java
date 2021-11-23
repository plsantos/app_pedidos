package com.app_pedidos.controller;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecosLista = repository.findAll();
        return EnderecoDTO.converter(enderecosLista);
    }

    @PostMapping
    public void save(@RequestBody Endereco endereco){
        repository.save(endereco);
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
    public void update(@PathVariable Long id, @RequestBody Endereco endereco){
    	try {
	        Endereco enderecoPesquisado = repository.getOne(id);
	        if(enderecoPesquisado != null){
	            enderecoPesquisado.setCidade(endereco.getCidade());
	            repository.save(enderecoPesquisado);
	        }
    	 }catch(EntityNotFoundException e) {
    		 throw new  ResourceNotFoundException("Id não encontrado "+id);
    	 }
    }

}
