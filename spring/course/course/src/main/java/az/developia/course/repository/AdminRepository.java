package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
