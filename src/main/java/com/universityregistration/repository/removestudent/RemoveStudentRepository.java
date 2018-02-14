package com.universityregistration.repository.removestudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entity.Student;

@Repository
public interface RemoveStudentRepository extends JpaRepository<Student, Integer> {
}
