package com.app_pedidos.controller;

import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<ClienteDTO> findAll(){
        List<Cliente> clientesLista = repository.findAll();
        return ClienteDTO.converter(clientesLista);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        Optional<Cliente> clientePesquisado = repository.findById(id);

        if(clientePesquisado.isPresent()){
            return repository.getById(id);
        }
        return null;
    }

    @PostMapping
    public void save(@RequestBody Cliente cliente){
        repository.save(cliente);
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
    public void update(@PathVariable Long id, @RequestBody Cliente cliente){
    	//try {
	        Cliente clientePesquisado = repository.getOne(id);
	        if(clientePesquisado != null){
	            clientePesquisado.setNome(cliente.getNome());
	            repository.save(clientePesquisado);
	        }}
//    	}catch(EntityNotFoundException e) {
//			throw new  ResourceNotFoundException("Id não encontrado "+id);
//		}


    /*@PutMapping("/{id}")
    public void update(@RequestBody Cliente p){
        repository.save(p);
    }*/
}
