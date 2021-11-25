package com.app_pedidos.controller;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import com.app_pedidos.model.services.ClienteService;
import com.app_pedidos.model.services.EnderecoService;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	@Autowired //injetando
	private EnderecoService service;
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
	}
}
