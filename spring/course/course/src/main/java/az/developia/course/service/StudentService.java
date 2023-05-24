package az.developia.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.course.exception.MyBadRequestException;
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
		
		Optional<Student> findedStudent = studentRepository.findById(id);
		if (findedStudent.isPresent()) {
			
			studentRepository.deleteById(id);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
		
	}



	public Optional<Student> findById(Integer id) {
		
		return studentRepository.findById(id);
	}
	

}
