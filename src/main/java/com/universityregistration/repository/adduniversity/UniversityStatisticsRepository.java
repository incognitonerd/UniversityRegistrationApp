package com.universityregistration.repository.adduniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entities.University;

@Repository
public interface UniversityStatisticsRepository extends JpaRepository<University, Long> {
	@Query("select count(s) from Student s where s.university.id=:id")
	Integer getNumOfStudentsForUniversity(@Param("id") Integer id);
}
