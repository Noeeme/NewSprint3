package com.example.sprint.repository;

import com.example.sprint.modelo.Cidade;
import com.example.sprint.modelo.Regiao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Page<Cidade> findByRegiao(Regiao nomeRegiao, Pageable paginacao);
}
