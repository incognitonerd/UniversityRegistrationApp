package com.universityregistration.repository.addstudent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entity.Student;

@Repository
public interface ShowAllStudentsRepository extends JpaRepository<Student, Long> {
	@Query("select s from Student s order by s.firstName")
	List<Student> getAllStudents();
}
