package com.f1rst.ada.gerenciadoremprestimo.repository;

import com.f1rst.ada.gerenciadoremprestimo.model.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {

}
