package com.app_pedidos.controller;

import com.app_pedidos.model.dto.ProdutoDTO;
import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Produto produto){
        Produto produtoPesquisado = repository.getOne(id);
        if (produtoPesquisado != null){
            produtoPesquisado.setDescricao(produto.getDescricao());
            repository.save(produtoPesquisado);
        }
    }
}
