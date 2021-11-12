package com.app_pedidos.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;

@Service // classe que concentra TODAS as regras de negocio
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void inativar(Long id) {
        Produto produtoExcluir = repository.getById(id);
        produtoExcluir.setStatus(false);
        repository.save(produtoExcluir);
    }
}
