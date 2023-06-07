package az.developia.course.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts")
public class StudentContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String contractNumber;
	private LocalDate contractDate;
	private LocalDate trainingStartDate;
	private Integer trainingDuration;
	private Double monthlyPayment;
	@OneToMany
	private List<TrainingCategory> trainingCategory;
	@OneToMany
	private List<Training> training;
	private String payment;
}
