package az.developia.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

	
	@GetMapping(path = "/validate")
	public void validationUsers() {
		
	}
	


}
