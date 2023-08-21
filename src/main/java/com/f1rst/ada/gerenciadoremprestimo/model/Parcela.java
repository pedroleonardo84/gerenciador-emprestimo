package com.f1rst.ada.gerenciadoremprestimo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Parcela {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
	@SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
	private Integer id;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private int numeroParcela;
	@JsonBackReference
	@ManyToOne
	private Proposta proposta;

	public Parcela(LocalDate dataPagamento, BigDecimal valor, int numeroParcela, Proposta proposta) {
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.numeroParcela = numeroParcela;
		this.proposta = proposta;
	}
	
	protected Parcela() {}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public Proposta getProposta() {
		return proposta;
	}

}
