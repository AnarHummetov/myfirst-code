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
	
	private ArrayList<Student> students = new ArrayList<>();
	{
		students.add(new Student(1, "Rakif", "Imamli", "imamli@gmail.com", "051-734"));
		students.add(new Student(1, "Medin", "Seydayev", "medin22@gmail.com", "055-674"));
		students.add(new Student(1, "Anar", "Memmedov", "memmedova0@gmail.com", "077-837"));
	}

	public ArrayList<Student> findAll() {
		return studentRepository.findAll();
	}

	public void add(Student s) {
		students.add(s);
	}
}
