package az.developia.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.course.exception.MyBadRequestException;
import az.developia.course.model.Teacher;
import az.developia.course.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	

	public List<Teacher> findAll() {
		
		return teacherRepository.findAll();
	}



	public void save(Teacher t) {
	
		teacherRepository.save(t);
	}
	
	
	public void deleteById(Integer id) {
		
		Optional<Teacher> findedStudent = teacherRepository.findById(id);
		if (findedStudent.isPresent()) {
			
			teacherRepository.deleteById(id);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	
	}

	
	public Optional<Teacher> findById(Integer id) {
		
		return teacherRepository.findById(id);
	}
	

}
