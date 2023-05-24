package az.developia.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.course.model.Student;
import az.developia.course.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	

	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}



	public void save(Student s) {
	
		studentRepository.save(s);
	}
	
	
	public void deleteById(Integer id) {
		
		studentRepository.deleteById(id);
	}
	

}
