package az.developia.course.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	private String username;
	private String password;
	
	
//	@OneToMany
//	@JoinColumn(name="authorities_id")
//	private List<AuthorityModel> authorities;
	

}
