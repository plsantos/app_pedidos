package com.app_pedidos.controller;

import com.app_pedidos.model.dto.PedidoDTO;
import com.app_pedidos.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService service;
    
    @PostMapping
	public ResponseEntity<PedidoDTO> insert(@RequestBody PedidoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
	}
    
    @GetMapping
	public ResponseEntity<List<PedidoDTO>>findAll(){
		List<PedidoDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
    
    @GetMapping(value="/{id}")
	public ResponseEntity<PedidoDTO>findById(@PathVariable Long id){
    	PedidoDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);//resposta 200 ou seja foi com sucesso
	}
    
    @PutMapping(value="/{id}")
	public ResponseEntity<PedidoDTO> update(@PathVariable Long id,@RequestBody PedidoDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
	}
    
    @DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    
}
