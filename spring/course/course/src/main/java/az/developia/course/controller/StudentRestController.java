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
import az.developia.course.model.Student;
import az.developia.course.model.UserModel;
import az.developia.course.repository.AuthorityRepository;
import az.developia.course.repository.UserRepository;
import az.developia.course.service.StudentService;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@GetMapping
	public List<Student> findAll() {
		return studentService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Student student) {
		student.setId(null);

		UserModel userModel = new UserModel();
		userModel.setUsername(student.getUsername());
		userModel.setPassword("{bcrypt}"+encoder.encode(student.getPassword()));
		userRepository.save(userModel);

		System.out.println(userModel);
		studentService.save(student);

		AuthorityModel authorityModel = new AuthorityModel();
		authorityModel.setUsername(student.getUsername());
		authorityModel.setAuthority("student");
		authorityRepository.save(authorityModel);
	}

	@PutMapping(path = "/edit")
	public void update(@RequestBody Student s) {

		if (s.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if (s.getId() == 0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Student> findedStudent = studentService.findById(s.getId());
		if (findedStudent.isPresent()) {
			studentService.save(s);
		} else {
			throw new MyBadRequestException("id tapılmadı");
		}

	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		studentService.deleteById(id);
	}

	@GetMapping(path = "/{id}")
	public Student findById(@PathVariable Integer id) {

		return studentService.findById(id).get();
	}

}
