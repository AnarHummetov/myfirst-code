package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import az.developia.course.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
