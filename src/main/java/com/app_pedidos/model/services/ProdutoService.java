package com.app_pedidos.model.services;

import com.app_pedidos.model.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;

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
}
