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
import az.developia.course.model.TrainingCategory;
import az.developia.course.repository.TrainingCategoryRepository;

@RestController
@RequestMapping(path = "/training-categories")
@CrossOrigin(origins = "*")
public class TrainingCategoryRestController {

	@Autowired
	private TrainingCategoryRepository trainingCategoryRepository;

	@GetMapping
	public List<TrainingCategory> findAll() {
		return trainingCategoryRepository.findAll();
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody TrainingCategory trainingCategory) {
		trainingCategory.setId(null);
		trainingCategoryRepository.save(trainingCategory);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody TrainingCategory trainingCategory) {
		if (trainingCategory.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(trainingCategory.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<TrainingCategory> findedGroup = trainingCategoryRepository.findById(trainingCategory.getId());
		if(findedGroup.isPresent()) {
			trainingCategoryRepository.save(trainingCategory);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		trainingCategoryRepository.deleteById(id);
	}
}
