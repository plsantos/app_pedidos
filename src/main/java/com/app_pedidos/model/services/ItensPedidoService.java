package com.app_pedidos.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app_pedidos.model.repositories.ItensPedidoRepository;

public class ItensPedidoService {
	@Autowired
	private ItensPedidoRepository repository;
}
