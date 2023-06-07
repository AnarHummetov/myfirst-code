package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.StudentContract;

public interface StudentContractRepository extends JpaRepository<StudentContract, Integer>{

}
