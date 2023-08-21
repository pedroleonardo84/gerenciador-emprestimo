package com.f1rst.ada.gerenciadoremprestimo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String nome;
        private BigDecimal patrimonio;
        private LocalDate dataContratacao;
        private BigDecimal salario;
        private String cpf;

        public Cliente(String nome, BigDecimal patrimonio, LocalDate dataContratacao, BigDecimal salario, String cpf) {
            this.nome = nome;
            this.patrimonio = patrimonio;
            this.dataContratacao = dataContratacao;
            this.salario = salario;
            this.cpf = cpf;
        }

        protected Cliente() {
        }

        public Integer getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public BigDecimal getPatrimonio() {
            return patrimonio;
        }

        public LocalDate getDataContratacao() {
            return dataContratacao;
        }

        public BigDecimal getSalario() {
            return salario;
        }

        public String getCpf() {
            return cpf;
        }

        public boolean passouExperiencia() {
            return ChronoUnit.MONTHS.between(LocalDate.now(), dataContratacao) >= 3;
        }

    }