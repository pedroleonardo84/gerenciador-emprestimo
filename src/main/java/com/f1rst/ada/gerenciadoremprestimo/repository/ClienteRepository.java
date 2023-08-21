package com.f1rst.ada.gerenciadoremprestimo.repository;

import com.f1rst.ada.gerenciadoremprestimo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
