package com.unireg.repo.addstudent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.Student;

@Repository
public interface ShowAllStuRepo extends JpaRepository<Student, Long> {
	@Query("select stu from Student stu order by stu.firstName")
	List<Student> getAllStus();
}
