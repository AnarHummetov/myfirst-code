package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import az.developia.course.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer>{

}
