package az.developia.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.course.exception.MyBadRequestException;
import az.developia.course.model.Manager;
import az.developia.course.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository ;
	
	

	public List<Manager> findAll() {
		
		return managerRepository.findAll();
	}



	public void save(Manager m) {
	
		managerRepository.save(m);
	}
	
	
	public void deleteById(Integer id) {
		
		Optional<Manager> findedStudent = managerRepository.findById(id);
		if (findedStudent.isPresent()) {
			
			managerRepository.deleteById(id);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}



	public Optional<Manager> findById(Integer id) {
		return managerRepository.findById(id);
	}

}
