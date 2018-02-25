package com.unireg.repo.security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unireg.model.entities.User;

@Repository
public interface LocateUserRepo extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username=:username")
	User locateByUsername(@Param("username") String username);
}
