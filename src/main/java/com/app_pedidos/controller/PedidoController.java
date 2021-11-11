package com.app_pedidos.controller;

import com.app_pedidos.model.dto.PedidoDTO;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido pedidoPesquisado = repository.getOne(id);
        if (pedidoPesquisado != null) {
            pedidoPesquisado.setData(pedido.getData());
            repository.save(pedidoPesquisado);
        }
    }
}
