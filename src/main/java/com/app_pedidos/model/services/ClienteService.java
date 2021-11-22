package com.app_pedidos.model.services;

import com.app_pedidos.controller.ClienteController;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public boolean verificaCPF(Long id){
        Cliente cliente = repository.getById(id);
        String documento = cliente.getDocumento();
        boolean verifica = false;

        for (Cliente c: repository.findAll()){
            if(documento == c.getDocumento()){
                verifica = false;
                break;
            }
            else
                verifica = true;
        }
        return verifica;
    }
}
