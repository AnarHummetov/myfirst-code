package az.developia.course.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import az.developia.course.exception.MyBadRequestException;
import az.developia.course.model.UserModel;
import az.developia.course.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
public void findById(UserModel user) {
		
		Optional<UserModel> userFinded=userRepository.findById(user.getUsername());
		if(userFinded.isPresent()) {
			throw new MyBadRequestException("bu username artiq var");
		}
}

}
