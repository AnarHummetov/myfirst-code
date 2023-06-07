package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Integer>{

}
