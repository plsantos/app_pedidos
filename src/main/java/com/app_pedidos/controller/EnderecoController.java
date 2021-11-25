package com.app_pedidos.controller;

import com.app_pedidos.model.dto.EnderecoDTO;
import com.app_pedidos.model.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
	
	@GetMapping
	public ResponseEntity<List<EnderecoDTO>>findAll(){
		List<EnderecoDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EnderecoDTO>findById(@PathVariable Long id){
		EnderecoDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);//resposta 200 ou seja foi com sucesso
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable Long id,@RequestBody EnderecoDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
}
