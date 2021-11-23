package com.app_pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_pedidos.model.dto.ItensPedidoDTO;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.ItensPedidoRepository;

@RestController
@RequestMapping(value = "/itensPedido")
public class ItensPedidoController {
	@Autowired // injetando
	private ItensPedidoRepository repository;

	@PostMapping
	public void save(@RequestBody ItensPedido itensPedido) {
		if(itensPedido.getProduto().isStatus())
			repository.save(itensPedido);
	}

	@GetMapping
	public List<ItensPedidoDTO> findAll() {
		List<ItensPedido> itensLista = repository.findAll();
		return ItensPedidoDTO.converter(itensLista);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ItensPedido itensPedido) {
		ItensPedido itensPedidoPesquisado = repository.getOne(id);
        if (itensPedidoPesquisado != null) {
        	itensPedidoPesquisado.setQuantidadeProduto(itensPedido.getQuantidadeProduto());
        	itensPedidoPesquisado.setProduto(itensPedido.getProduto());
            repository.save(itensPedidoPesquisado);
        }
    }
}
