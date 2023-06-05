package az.developia.course.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Author")
public class Author {
	
	@Id
	private Integer id;
	private String name;
	private String surname;
	private Date birthday;
	private String phone;
	private String email;
}
