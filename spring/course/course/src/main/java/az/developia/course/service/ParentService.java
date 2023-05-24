package az.developia.course.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.developia.course.model.Parent;
import az.developia.course.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	

	public List<Parent> findAll() {
		
		return parentRepository.findAll();
	}



	public void save(Parent p) {
	
		parentRepository.save(p);
	}
	
	
	public void deleteById(Integer id) {
		
		parentRepository.deleteById(id);
	}
	

}
