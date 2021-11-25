package com.app_pedidos.controller;
import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired //injetando
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>>findAll(){
		List<ClienteDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
