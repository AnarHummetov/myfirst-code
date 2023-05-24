package az.developia.course.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String surname;
	private Date birthday;
	private String phone;
	private String email;
	private String address;
	private String training;
	private String sector;
	private String gender;
	private String parent;
	private String nationality;
	private String idCardSeries;
	private String idCardPin;
	private String region;
	private String applySource;
	private String notes;
	private String hobbies;

}
