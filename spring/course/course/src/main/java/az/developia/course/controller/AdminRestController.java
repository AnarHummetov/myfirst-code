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
import az.developia.course.model.Admin;
import az.developia.course.service.AdminService;

@RestController
@RequestMapping(path = "/admins")
@CrossOrigin(origins = "*")
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public List<Admin> findAll() {
		return adminService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Admin a) {
		a.setId(null);
		adminService.save(a);
	}

	@PutMapping(path = "/edit")
	public void update(@RequestBody Admin a) {
		if (a.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(a.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Admin> findedAdmin = adminService.findById(a.getId());
		if(findedAdmin.isPresent()) {
			adminService.save(a);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		adminService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public Admin findById(@PathVariable Integer id) {

		return adminService.findById(id).get();
	}
}
