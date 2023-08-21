package com.f1rst.ada.gerenciadoremprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.f1rst.ada.gerenciadoremprestimo.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

}
