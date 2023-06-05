package az.developia.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import az.developia.course.model.CourseModel;
import az.developia.course.repository.CourseRepository;

@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "*")
public class AuthorCourseRestController {
 
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<CourseModel> findCourses(){
		return courseRepository.findAll();
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody CourseModel courseModel) {
		courseModel.setId(null);
		courseRepository.save(courseModel);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody CourseModel courseModel) {
		if (courseModel.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(courseModel.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<CourseModel> findedCourse = courseRepository.findById(courseModel.getId());
		if(findedCourse.isPresent()) {
			courseRepository.save(courseModel);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		courseRepository.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public CourseModel findById(@PathVariable Integer id) {

		return courseRepository.findById(id).get();
}
}
