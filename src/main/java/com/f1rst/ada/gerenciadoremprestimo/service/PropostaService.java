package com.f1rst.ada.gerenciadoremprestimo.service;


import com.f1rst.ada.gerenciadoremprestimo.model.Cliente;
import com.f1rst.ada.gerenciadoremprestimo.model.Proposta;
import com.f1rst.ada.gerenciadoremprestimo.model.dto.PropostaInputDto;
import com.f1rst.ada.gerenciadoremprestimo.repository.PropostaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class PropostaService {

	private final PropostaRepository propostaRepository;
	private final ClienteService clienteService;
	private final ParcelaService parcelaService;
	
	public PropostaService(PropostaRepository propostaRepository, ClienteService clienteService, ParcelaService parcelaService) {
		this.propostaRepository = propostaRepository;
		this.clienteService = clienteService;
		this.parcelaService = parcelaService;
	}

	@Transactional
	public Proposta criarProposta(PropostaInputDto propostaInput) {
		Cliente cliente = clienteService.obter(propostaInput.getClienteId());
		Proposta proposta = propostaInput.converte(cliente);
		Proposta save = propostaRepository.save(proposta);
		parcelaService.saveAll(proposta.getParcelas());
		return save; 
	}

	@Transactional
	public Proposta aprovar(Integer id) {
		Proposta proposta = propostaRepository.getById(id);
		proposta.aprovar();
		return proposta;
	}

}
