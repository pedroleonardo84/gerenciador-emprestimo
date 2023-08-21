package com.f1rst.ada.gerenciadoremprestimo.service;


import com.f1rst.ada.gerenciadoremprestimo.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

	private String secret = "falksdflkajf";
	private long expiration = 1800000;

	public String geraToken(Authentication authentication) {
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date exp = new Date(hoje.getTime() + expiration);

		return Jwts.builder()
				.setIssuer("Minha aplicação")
				.setSubject(usuarioLogado.getId()
				.toString())
				.setIssuedAt(hoje)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public boolean validaToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Integer getUsuarioId(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.getSubject());
	}
}
