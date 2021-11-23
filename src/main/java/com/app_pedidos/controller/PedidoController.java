package com.app_pedidos.controller;

import com.app_pedidos.model.dto.PedidoDTO;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidosLista = repository.findAll();
        return PedidoDTO.converter(pedidosLista);
    }

    @PostMapping
    public void save(@RequestBody Pedido pedido) {
            repository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	try {
    		repository.deleteById(id);
    	}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedidoPesquisado = repository.getOne(id);
        if (pedidoPesquisado != null && pedidoPesquisado.isSituacao()) {
            pedidoPesquisado.setData(pedido.getData());
            repository.save(pedidoPesquisado);
        }
    }
}
