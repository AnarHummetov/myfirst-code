package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.TrainingCategory;

public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, Integer>{

}
