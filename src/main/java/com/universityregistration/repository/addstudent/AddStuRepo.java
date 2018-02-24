package com.universityregistration.repository.addstudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entities.Student;

@Repository
public interface AddStuRepo extends JpaRepository<Student, Integer> {
}
