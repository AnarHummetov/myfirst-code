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
import az.developia.course.model.Training;
import az.developia.course.repository.TrainingRepository;

@RestController
@RequestMapping(path = "/trainings")
@CrossOrigin(origins = "*")
public class TrainingRestController {

	@Autowired
	private TrainingRepository trainingRepository;

	@GetMapping
	public List<Training> findAll() {
		return trainingRepository.findAll();
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody Training training) {
		training.setId(null);
		trainingRepository.save(training);
	}
	
	@PutMapping(path = "/edit")
	public void update(@RequestBody Training training) {
		if (training.getId() == null) {
			throw new MyBadRequestException("id null olmamalıdır");
		}
		if(training.getId()==0) {
			throw new MyBadRequestException("id 0 olmamalıdır");
		}
		Optional<Training> findedGroup = trainingRepository.findById(training.getId());
		if(findedGroup.isPresent()) {
			trainingRepository.save(training);
		}else {
			throw new MyBadRequestException("id tapılmadı");
		}
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		trainingRepository.deleteById(id);
	}
}
