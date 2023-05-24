package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
