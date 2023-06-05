package az.developia.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.course.model.TeacherGroup;

public interface GroupRepository extends JpaRepository<TeacherGroup, Integer>{

	public List<TeacherGroup> findAllByTeacherUsername(String teacherUsername);
}
