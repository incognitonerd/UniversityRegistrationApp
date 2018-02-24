package com.universityregistration.repository.adduniversity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.universityregistration.model.entities.University;

@Repository
public interface ShowAllUnisRepo extends JpaRepository<University, Long> {
	@Query("select uni from University uni order by uni.name")
	List<University> getAllUnis();
	
	@Query("select count(stu) from Student stu where stu.university.id=:id")
	Integer getNumOfStusForUni(@Param("id") Integer id);
}