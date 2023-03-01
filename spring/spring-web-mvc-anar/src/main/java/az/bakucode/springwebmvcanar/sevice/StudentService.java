package az.bakucode.springwebmvcanar.sevice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.bakucode.springwebmvcanar.model.Student;
import az.bakucode.springwebmvcanar.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public ArrayList<Student> findAll() {
		return studentRepository.findAll();
	}

	public void add(Student s) {
		studentRepository.add(s);
	}
}
