package com.f1rst.ada.gerenciadoremprestimo.controller;


import com.f1rst.ada.gerenciadoremprestimo.model.Usuario;
import com.f1rst.ada.gerenciadoremprestimo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
}
