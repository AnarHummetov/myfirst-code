package az.developia.course.model;

import java.sql.Date;
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
@Table(name = "groups")
public class TeacherGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String groupName;
	private String trainingCategory;
	private String training;
	private String lessonDayHour;
	
	@OneToMany
	//@JoinColumn(name = "student_id")
	private List<Student> students;
	
	private String teacherUsername;

}
