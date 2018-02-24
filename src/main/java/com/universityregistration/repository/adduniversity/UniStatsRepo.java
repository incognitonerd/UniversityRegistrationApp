package com.universityregistration.repository.adduniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entities.University;

@Repository
public interface UniStatsRepo extends JpaRepository<University, Long> {
	@Query("select count(stu) from Student stu where stu.university.id=:id")
	Integer getNumOfStusForUniv(@Param("id") Integer id);
}
