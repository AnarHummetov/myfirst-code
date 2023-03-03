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
			ResultSet rs = st.executeQuery("select * from students");
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

	public void add(Student s) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			if (s.getId() == null) {
				st.executeUpdate("insert into students(name,surname,email,phone) "
						+ "values('"+s.getName()+"','"+s.getSurname()+"','"+s.getEmail()+"','"+s.getPhone()+"')");

			} else {
				st.executeUpdate("update students set name='" + s.getName() + "',surname='" + s.getSurname()
						+ "',email='" + s.getEmail() + "',phone='" + s.getPhone() + "' " + " where id=" + s.getId());

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public void deleteById(Integer id) {

		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("delete from students where id=" + id);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Student findById(Integer id) {
		Student s = null;
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from students where id=" + id);
			if (rs.next()) {

				s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("email"),
						rs.getString("phone"));

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
