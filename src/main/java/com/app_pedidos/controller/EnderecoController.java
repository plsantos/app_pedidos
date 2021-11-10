package com.app_pedidos.controller;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Endereco endereco){
        Endereco enderecoPesquisado = repository.getOne(id);
        if(enderecoPesquisado != null){
            enderecoPesquisado.setCidade(endereco.getCidade());
            repository.save(enderecoPesquisado);
        }
    }

}
