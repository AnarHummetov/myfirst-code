package az.developia.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import az.developia.course.exception.MyBadRequestException;
import az.developia.course.model.Admin;
import az.developia.course.repository.AdminRepository;

public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository ;
	
	

	public List<Admin> findAll() {
		
		return adminRepository.findAll();
	}



	public void save(Admin a) {
	
		adminRepository.save(a);
	}
	
	
	public void deleteById(Integer id) {
		
		adminRepository.deleteById(id);
	}



	public Optional<Admin> findById(Integer id) {
		
		Optional<Admin> findedStudent = adminRepository.findById(id);
		if (findedStudent.isPresent()) {
			
			return adminRepository.findById(id);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
	
	}

}
