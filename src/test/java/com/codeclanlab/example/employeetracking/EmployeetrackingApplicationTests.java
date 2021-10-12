package com.codeclanlab.example.employeetracking;

import com.codeclanlab.example.employeetracking.models.Department;
import com.codeclanlab.example.employeetracking.models.Employee;
import com.codeclanlab.example.employeetracking.repositories.DepartmentRepository;
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
	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment(){
		Department dept = new Department("Finance");
		Employee bond = new Employee("James Bond", 46, "007-LTK", "bondjbond@mi6.gov.uk", dept);
		departmentRepository.save(dept);
		employeeRepository.save(bond);

	}

}
