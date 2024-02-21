package com.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface employeeRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email =?1")
	User findByEmail(String email);
}
