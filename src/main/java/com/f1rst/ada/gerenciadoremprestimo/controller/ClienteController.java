package com.f1rst.ada.gerenciadoremprestimo.controller;

import com.f1rst.ada.gerenciadoremprestimo.model.Cliente;
import com.f1rst.ada.gerenciadoremprestimo.model.dto.ClienteInputDto;
import com.f1rst.ada.gerenciadoremprestimo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody ClienteInputDto clienteDto) {
		
		Cliente cliente = clienteService.criar(clienteDto);
		URI uri = UriComponentsBuilder.fromPath("clientes/{id}").buildAndExpand(cliente .getId()).toUri();
		return ResponseEntity.created(uri ).body(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		return ResponseEntity.ok(this.clienteService.obter(id));
	}
	
	@GetMapping("/buscartodos")
	public List<Cliente> buscarTodos(){
		return clienteService.buscarTodos();
	}
	
	
}
