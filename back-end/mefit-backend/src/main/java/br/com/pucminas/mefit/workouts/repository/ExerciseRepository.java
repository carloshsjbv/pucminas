package br.com.pucminas.mefit.workouts.repository;

import br.com.pucminas.mefit.workouts.entity.ExerciseEntity;
import br.com.pucminas.mefit.workouts.entity.MuscularGroupEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    List<ExerciseEntity> findByMuscularGroup(MuscularGroupEnum muscularGroup);

}
