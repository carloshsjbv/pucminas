package com.puc.gerenciador.consultorias.plano.treinamento.repository;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.PlanoTreinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoTreinoRepository extends JpaRepository<PlanoTreinoEntity, Long> {
}
