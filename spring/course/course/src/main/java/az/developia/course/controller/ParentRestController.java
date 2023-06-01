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
import az.developia.course.model.Parent;
import az.developia.course.service.ParentService;

@RestController
@RequestMapping(path = "/parents")
@CrossOrigin(origins = "*")
public class ParentRestController {

	@Autowired
	private ParentService parentService;

	@GetMapping
	public List<Parent> findAll() {
		return parentService.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Parent p) {
		p.setId(null);
		parentService.save(p);
	}

	@PutMapping(path = "/edit")
	public void update(@RequestBody Parent p) {
		if (p.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(p.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Parent> findedParent = parentService.findById(p.getId());
		if(findedParent.isPresent()) {
			parentService.save(p);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		parentService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public Parent findById(@PathVariable Integer id) {

		return parentService.findById(id).get();
	}
}
