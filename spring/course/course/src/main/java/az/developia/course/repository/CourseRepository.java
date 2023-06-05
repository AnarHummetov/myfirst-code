package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel, Integer> {

}
