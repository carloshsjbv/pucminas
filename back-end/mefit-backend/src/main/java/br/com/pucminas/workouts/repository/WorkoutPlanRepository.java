package br.com.pucminas.workouts.repository;

import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlanEntity, Long> {

    List<WorkoutPlanEntity> findAllByPersonalTrainerIdInAndActive(final Collection<Long> personalTrainerId, final boolean active);

    List<WorkoutPlanEntity> findAllBySent(final Boolean sent);
}
