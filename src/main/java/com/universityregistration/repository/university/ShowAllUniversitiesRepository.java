package com.universityregistration.repository.university;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entity.University;

@Repository
public interface ShowAllUniversitiesRepository extends JpaRepository<University, Long> {
	@Query("select u from University u order by u.name")
	List<University> getAllUniversities();
	
	@Query("select count(s) from Student s where s.university.id=:id")
	Integer getNumOfStudentsForUniversity(@Param("id") Integer id);
}