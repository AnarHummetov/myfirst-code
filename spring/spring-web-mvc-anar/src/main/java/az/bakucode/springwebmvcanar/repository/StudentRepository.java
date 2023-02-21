package az.bakucode.springwebmvcanar.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.bakucode.springwebmvcanar.model.Student;

@Repository
public class StudentRepository {

	@Autowired
	private DataSource dataSource;

	public ArrayList<Student> findAll() {

		ArrayList<Student> students = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {

				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone"));
				students.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

}
