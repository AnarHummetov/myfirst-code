package az.bakucode.springwebmvcanar.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.bakucode.springwebmvcanar.model.Student;

@Controller
@RequestMapping(path = "/students")
public class StudentController {
	ArrayList<Student> students = new ArrayList<>();
	{
		students.add(new Student(1, "Rakif", "Imamli", "imamli@gmail.com", "051-734"));
		students.add(new Student(1, "Medin", "Seydayev", "medin22@gmail.com", "055-674"));
		students.add(new Student(1, "Anar", "Memmedov", "memmedova0@gmail.com", "077-837"));
	}

	@GetMapping
	public String showStudent(Model a, @RequestParam(name = "q", required = false, defaultValue = "") String query) {

		ArrayList<Student> filteredStudents = new ArrayList<>();
		for (Student s : students) {
			if (s.getName().contains(query)) {
				filteredStudents.add(s);
			}
		}
		a.addAttribute("students", filteredStudents);
		return "students";
	}

	@GetMapping(path = "/open-save-page")
	public String openSavePage(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
		return "save-student";

	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute Student student) {
		students.add(student);
		return "redirect:/student";
	}
}
