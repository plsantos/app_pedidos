package com.app_pedidos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.app_pedidos.model.dto.ProdutoDTO;
import com.app_pedidos.model.services.ProdutoService;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    
       
    @PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
	}
    
    @GetMapping
	public ResponseEntity<List<ProdutoDTO>>findAll(){
		List<ProdutoDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
    
    @GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO>findById(@PathVariable Long id){
    	ProdutoDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);//resposta 200 ou seja foi com sucesso
	}
	
    @PutMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id,@RequestBody ProdutoDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
	}
    
    @DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
