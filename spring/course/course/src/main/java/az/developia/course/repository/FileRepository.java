package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.course.model.FileModel;

public interface FileRepository extends JpaRepository<FileModel, Integer> {

	@Query(value="select * from files where FILEUUIDNAME = ?1",nativeQuery = true )
	FileModel findByName(String filename);

}
