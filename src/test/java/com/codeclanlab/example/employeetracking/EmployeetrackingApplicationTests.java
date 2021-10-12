package com.codeclanlab.example.employeetracking;

import com.codeclanlab.example.employeetracking.models.Department;
import com.codeclanlab.example.employeetracking.models.Employee;
import com.codeclanlab.example.employeetracking.models.Project;
import com.codeclanlab.example.employeetracking.repositories.DepartmentRepository;
import com.codeclanlab.example.employeetracking.repositories.EmployeeRepository;
import com.codeclanlab.example.employeetracking.repositories.ProjectRepository;
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
	@Autowired
	ProjectRepository projectRepository;

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

	@Test
	public void addEmployeesAndProjects(){
		Department dept1 = new Department("Finance");
		departmentRepository.save(dept1);
		Department dept2 = new Department("Acquisitions");
		departmentRepository.save(dept2);
		Department dept3 = new Department("HR");
		departmentRepository.save(dept3);
		Employee smith = new Employee("Jeff", 38, "002-kdl", "jhjh@khkhj.kjhjh", dept1);
		employeeRepository.save(smith);
		Employee jones = new Employee("Jim", 33, "002-kdk", "jereerer@khkhj.kjhjh", dept2);
		employeeRepository.save(jones);
		Employee brown = new Employee("Jane", 32, "002-kdc", "jqwqwqwqwq@khkhj.kjhjh", dept3);
		employeeRepository.save(brown);

		Project demoproject = new Project("Top Secret Shit", 30);
		Project deltaproject = new Project("Super Top Secret Shit", 40);
		demoproject.addEmployee(smith);
		demoproject.addEmployee(brown);
		deltaproject.addEmployee(jones);

		projectRepository.save(demoproject);

		projectRepository.save(deltaproject);



	}


}
