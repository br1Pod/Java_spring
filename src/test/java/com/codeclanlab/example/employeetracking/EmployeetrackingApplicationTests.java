package com.codeclanlab.example.employeetracking;

import com.codeclanlab.example.employeetracking.models.Employee;
import com.codeclanlab.example.employeetracking.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeetrackingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee(){
		Employee bond = new Employee("James Bond", 46, "007-LTK", "bondjbond@mi6.gov.uk");
		employeeRepository.save(bond);
	}

}
