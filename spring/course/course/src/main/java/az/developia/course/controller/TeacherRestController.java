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

import az.developia.course.model.Teacher;
import az.developia.course.service.TeacherService;

@RestController
@RequestMapping(path = "/teachers")
public class TeacherRestController {

	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping
	public List<Teacher> findAll(){
		return teacherService.findAll();
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody Teacher t) {
		t.setId(null);
		teacherService.save(t);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody Teacher t) {
		teacherService.save(t);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		teacherService.deleteById(id);
	}
}
