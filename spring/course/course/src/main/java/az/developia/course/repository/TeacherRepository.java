package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
