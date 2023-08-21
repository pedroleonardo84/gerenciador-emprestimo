package com.f1rst.ada.gerenciadoremprestimo.service;

import com.f1rst.ada.gerenciadoremprestimo.model.Parcela;
import com.f1rst.ada.gerenciadoremprestimo.repository.ParcelaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelaService {

	private final ParcelaRepository parcelaRepository;

	public ParcelaService(ParcelaRepository parcelaRepository) {
		this.parcelaRepository = parcelaRepository;
	}

	public List<Parcela> saveAll(List<Parcela> parcelas) {
		return parcelaRepository.saveAll(parcelas);
	}

}
