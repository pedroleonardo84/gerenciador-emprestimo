package com.f1rst.ada.gerenciadoremprestimo.controller;


import com.f1rst.ada.gerenciadoremprestimo.model.dto.FormLoginDto;
import com.f1rst.ada.gerenciadoremprestimo.model.dto.TokenDto;
import com.f1rst.ada.gerenciadoremprestimo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autentica(@RequestBody FormLoginDto formLogin){
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(formLogin.getEmail(), formLogin.getSenha()));
		String token = tokenService.geraToken(authenticate);
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
