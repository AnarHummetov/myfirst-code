package az.developia.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import az.developia.course.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String>{
	
}
