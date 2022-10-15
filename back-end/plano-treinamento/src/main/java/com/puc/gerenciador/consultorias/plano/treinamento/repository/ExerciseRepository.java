package com.puc.gerenciador.consultorias.plano.treinamento.repository;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.MuscularGroupEnum;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    List<ExerciseEntity> findByMuscularGroup(MuscularGroupEnum muscularGroup);

}
