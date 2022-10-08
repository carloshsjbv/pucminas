package com.puc.gerenciador.consultorias.plano.treinamento.repository;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.EnumGrupoMuscular;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Long> {

    List<ExercicioEntity> findByGrupoMuscular(EnumGrupoMuscular enumGrupoMuscular);

}
