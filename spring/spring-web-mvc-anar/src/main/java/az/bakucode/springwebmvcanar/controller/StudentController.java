package az.bakucode.springwebmvcanar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.bakucode.springwebmvcanar.model.Student;
import az.bakucode.springwebmvcanar.sevice.StudentService;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public String showStudent(Model a, @RequestParam(name = "q", required = false, defaultValue = "") String query) {

		ArrayList<Student> filteredStudents = new ArrayList<>();
		for (Student s : studentService.findAll()) {
			String name = s.getName();
			name = name == null ? "" : name;
			if (name.contains(query)) {
				filteredStudents.add(s);
			}
		}
		a.addAttribute("students", filteredStudents);
		return "students";
	}

	@GetMapping(path = "/open-save-page")
	public String openSavePage(Model model) {
		Student s = new Student();
		model.addAttribute("header","Yeni telebe qeydi");
		model.addAttribute("student", s);
		return "save-student";

	}

	@PostMapping(path = "/save")
	public String save(@ModelAttribute Student student) {
		studentService.add(student);
		return "redirect:/students";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(Model model,@PathVariable Integer id) {
		studentService.deleteById(id);
		return "redirect:/students";

	}
	@GetMapping(path="/edit/{id}")
	public String edit(Model model,@PathVariable Integer id) {
		Student s=studentService.findById(id);
		if (s==null) {
			return "not-found";
		}
		model.addAttribute("header","Telebe redaktesi ");
		model.addAttribute("student", s);
		return "save-student";
	}
}
