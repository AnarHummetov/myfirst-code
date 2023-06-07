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
import az.developia.course.model.StudentContract;
import az.developia.course.repository.StudentContractRepository;

@RestController
@RequestMapping(path = "/contracts")
@CrossOrigin(origins = "*")
public class StudentContractRestController {

	@Autowired
	private StudentContractRepository contractRepository;

	@GetMapping
	public List<StudentContract> findAll() {
		return contractRepository.findAll();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody StudentContract contract) {
		contract.setId(null);
		contractRepository.save(contract);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody StudentContract contract) {
		if (contract.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(contract.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<StudentContract> findedContract = contractRepository.findById(contract.getId());
		if(findedContract.isPresent()) {
			contractRepository.save(contract);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		contractRepository.deleteById(id);
	}
	
	@GetMapping(path = "/{id}")
	public StudentContract findById(@PathVariable Integer id) {

		return contractRepository.findById(id).get();
	}
}
