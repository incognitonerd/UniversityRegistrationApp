package com.unireg.repo.removestudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.Student;

@Repository
public interface RemoveStuRepo extends JpaRepository<Student, Integer> {
}
