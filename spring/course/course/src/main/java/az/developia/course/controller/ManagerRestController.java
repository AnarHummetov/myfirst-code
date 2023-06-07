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
import az.developia.course.model.Manager;
import az.developia.course.model.UserModel;
import az.developia.course.repository.AuthorityRepository;
import az.developia.course.repository.UserRepository;
import az.developia.course.service.ManagerService;

@RestController
@RequestMapping(path = "/managers")
@CrossOrigin(origins = "*")
public class ManagerRestController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


	@GetMapping
	public List<Manager> findAll() {
		return managerService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Manager manager) {
		manager.setId(null);
		UserModel userModel = new UserModel();
		userModel.setUsername(manager.getUsername());
		userModel.setPassword("{bcrypt}"+encoder.encode(manager.getPassword()));
		userRepository.save(userModel);

		System.out.println(userModel);
		managerService.save(manager);

		AuthorityModel authorityModel = new AuthorityModel();
		authorityModel.setUsername(manager.getUsername());
		authorityModel.setAuthority("manager");
		authorityRepository.save(authorityModel);
		
	}

	@PutMapping(path = "/edit")
	public void update(@RequestBody Manager m) {
		if (m.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(m.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Manager> findedManager = managerService.findById(m.getId());
		if(findedManager.isPresent()) {
			managerService.save(m);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		managerService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public Manager findById(@PathVariable Integer id) {

		return managerService.findById(id).get();
	}
}
