package com.app_pedidos.controller;

import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public void save(@RequestBody Cliente cliente){
        repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clientePesquisado = repository.getOne(id);
        if(clientePesquisado != null){
            clientePesquisado.setNome(cliente.getNome());
            repository.save(clientePesquisado);
        }
    }
}
