package com.universityregistration.repository.adduniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entities.University;

@Repository
public interface AddUniversityRepository extends JpaRepository<University, Integer> {
}
