package com.unireg.repo.adduniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.University;

@Repository
public interface ShowUniStatsRepo extends JpaRepository<University, Long> {
	@Query("select count(stu) from Student stu where stu.university.id=:id")
	Integer getNumOfStusForUni(@Param("id") Integer id);
}
