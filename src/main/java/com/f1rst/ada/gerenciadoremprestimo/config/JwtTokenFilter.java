package com.f1rst.ada.gerenciadoremprestimo.config;

import com.f1rst.ada.gerenciadoremprestimo.model.Usuario;
import com.f1rst.ada.gerenciadoremprestimo.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private AutenticacaoService autenticacaoService;

	public JwtTokenFilter(TokenService tokenService, AutenticacaoService autenticacaoService) {
		this.tokenService = tokenService;
		this.autenticacaoService = autenticacaoService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if (tokenService.validaToken(token)) {
			autenticaUsuario(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticaUsuario(String token) {
		Integer idUsuario = tokenService.getUsuarioId(token);
		Usuario usuario = autenticacaoService.buscarPorId(idUsuario);
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario, null,
				usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7);
	}

}
