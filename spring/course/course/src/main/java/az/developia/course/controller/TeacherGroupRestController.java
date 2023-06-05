package az.developia.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
