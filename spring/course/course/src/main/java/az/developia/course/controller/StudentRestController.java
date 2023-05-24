package az.developia.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.course.model.Student;
import az.developia.course.service.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> findAll(){
		return studentService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Student s) {
		s.setId(null);
		studentService.save(s);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody Student s) {
		studentService.save(s);
	}
	
	
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		studentService.deleteById(id);
	}
}
