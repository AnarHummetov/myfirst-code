package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.FileModel;

public interface FileRepository extends JpaRepository<FileModel, Integer> {



}
