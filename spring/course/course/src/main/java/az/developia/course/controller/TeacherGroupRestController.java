package az.developia.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import az.developia.course.model.TeacherGroup;
import az.developia.course.repository.GroupRepository;

@RestController
@RequestMapping(path = "/groups")
@CrossOrigin(origins = "*")
public class TeacherGroupRestController {

	@Autowired
	private GroupRepository groupRepository;
	
	@GetMapping
	public List<TeacherGroup> findTeacherGroups(){
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		
		return groupRepository.findAllByTeacherUsername(username);
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody TeacherGroup group) {
		group.setId(null);
		groupRepository.save(group);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody TeacherGroup group) {
		if (group.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(group.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<TeacherGroup> findedGroup = groupRepository.findById(group.getId());
		if(findedGroup.isPresent()) {
			groupRepository.save(group);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		groupRepository.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public TeacherGroup findById(@PathVariable Integer id) {

		return groupRepository.findById(id).get();
	}
}
