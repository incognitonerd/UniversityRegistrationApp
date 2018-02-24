package com.unireg.repo.addstudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.Student;

@Repository
public interface AddStuRepo extends JpaRepository<Student, Integer> {
}
