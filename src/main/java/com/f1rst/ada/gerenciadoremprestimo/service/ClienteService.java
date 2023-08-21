package com.f1rst.ada.gerenciadoremprestimo.service;

import com.f1rst.ada.gerenciadoremprestimo.model.Cliente;
import com.f1rst.ada.gerenciadoremprestimo.model.dto.ClienteInputDto;
import com.f1rst.ada.gerenciadoremprestimo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente criar(ClienteInputDto clienteDto) {
		Cliente cliente = clienteDto.converte();
		return clienteRepository.save(cliente);
	}

	public Cliente obter(Integer id) {
		return clienteRepository.getById(id);
	}

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

}
