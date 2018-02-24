package com.unireg.repo.adduniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.University;

@Repository
public interface AddUniRepo extends JpaRepository<University, Integer> {
}
