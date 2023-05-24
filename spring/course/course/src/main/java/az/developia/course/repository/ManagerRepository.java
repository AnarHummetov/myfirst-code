package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
