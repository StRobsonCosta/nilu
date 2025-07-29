package com.kavex.nilu.domain.repository;

import com.kavex.nilu.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
