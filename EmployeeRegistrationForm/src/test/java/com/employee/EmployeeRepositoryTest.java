package com.employee;

import com.employee.User;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {
	@Autowired
	private employeeRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	//Test method for creating a new employ
	@Test
	public void testCreateEmployee() {
		User emp = new User();
		emp.setEmail("kiranpd@gmail.com");
		emp.setPassword("123456");
		emp.setFirstName("Kiran");
		emp.setLastName("Dhandare");
		emp.setAddress("Hinjewadi Pune");
		emp.setPhoneNumber("0123456789");
		
		User savedEmp = repo.save(emp);
		User existEmp = entityManager.find(User.class, savedEmp.getId());
		
		assertThat(existEmp.getEmail()).isEqualTo(emp.getEmail());
		
	}
	
	
	
}
