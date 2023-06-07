package az.developia.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.exception.MyBadRequestException;
import az.developia.course.model.AuthorityModel;
import az.developia.course.model.Parent;
import az.developia.course.model.UserModel;
import az.developia.course.repository.AuthorityRepository;
import az.developia.course.repository.UserRepository;
import az.developia.course.service.ParentService;

@RestController
@RequestMapping(path = "/parents")
@CrossOrigin(origins = "*")
public class ParentRestController {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


	@GetMapping
	public List<Parent> findAll() {
		return parentService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Parent parent) {
		parent.setId(null);
		
		UserModel userModel = new UserModel();
		userModel.setUsername(parent.getUsername());
		userModel.setPassword("{bcrypt}"+encoder.encode(parent.getPassword()));
		userRepository.save(userModel);

		System.out.println(userModel);
		parentService.save(parent);

		AuthorityModel authorityModel = new AuthorityModel();
		authorityModel.setUsername(parent.getUsername());
		authorityModel.setAuthority("parent");
		authorityRepository.save(authorityModel);
		
	}

	@PutMapping(path = "/edit")
	public void update(@RequestBody Parent p) {
		if (p.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(p.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Parent> findedParent = parentService.findById(p.getId());
		if(findedParent.isPresent()) {
			parentService.save(p);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		parentService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public Parent findById(@PathVariable Integer id) {

		return parentService.findById(id).get();
	}
}
