package com.f1rst.ada.gerenciadoremprestimo.controller;


import com.f1rst.ada.gerenciadoremprestimo.model.Proposta;
import com.f1rst.ada.gerenciadoremprestimo.model.dto.PropostaInputDto;
import com.f1rst.ada.gerenciadoremprestimo.service.PropostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("propostas")
public class PropostaController {

	private final PropostaService propostaService;
	public PropostaController(PropostaService propostaService) {
		this.propostaService = propostaService;
	}
	
	@PostMapping
	public ResponseEntity<Proposta>criar(@RequestBody PropostaInputDto propostaDto){
		PropostaInputDto propostaInput = propostaDto;
		Proposta proposta = propostaService.criarProposta(propostaInput);
		URI uri = UriComponentsBuilder.fromPath("propostas/{id}").buildAndExpand(proposta.getId()).toUri();
		return ResponseEntity.created(uri).body(proposta);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Proposta> aprovarProposta(@PathVariable Integer id){
		Proposta proposta = propostaService.aprovar(id);
		return ResponseEntity.ok(proposta);
	}
}