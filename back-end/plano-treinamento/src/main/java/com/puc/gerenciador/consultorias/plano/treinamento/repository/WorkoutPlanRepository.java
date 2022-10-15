package com.puc.gerenciador.consultorias.plano.treinamento.repository;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.WorkoutPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlanEntity, Long> {

    List<WorkoutPlanEntity> findAllByPersonalTrainerIdInAndActive(final Collection<Long> personalTrainerId, final boolean active);

    List<WorkoutPlanEntity> findAllBySent(final Boolean sent);
}
