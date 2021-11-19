package com.app_pedidos.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public void inativar(Long id) {
        Pedido pedidoInativo = repository.getById(id);
        pedidoInativo.setSituacao(false);
        repository.save(pedidoInativo);
    }
}
