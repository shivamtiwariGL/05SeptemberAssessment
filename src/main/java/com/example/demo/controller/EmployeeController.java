package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	private List<Employee> employees = createList();

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		System.out.println("get@@@@@@@@@@@@@@@@@2");
		return employees;
	}

	@DeleteMapping( "/employees/{id}" )
	public Employee delete(@PathVariable("id") String id) {
		System.out.println("delete.................."+id);
		Employee deletedEmp = null;
		System.out.println(employees);
		for (Employee emp : employees) {
			
			if (emp.getEmpId().equals(id)) {
				System.out.println("id ******************  "+ id);
				System.out.println(employees.size());
				employees.remove(emp);
				System.out.println(employees.size());
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		
		employees.add(user);
		System.out.println(employees+"  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return user;
	}
	
	 @PutMapping("/employees/{id}") public Employee update(@PathVariable("id")
	  String id,@RequestBody Employee user) { employees.add(user);
	  System.out.println(employees+" Update $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	  return user;
	  
	  
	  }
	

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("Shivam");
		emp1.setDesignation("Software Engineer");
		emp1.setEmpId("1");
		emp1.setSalary(75000);

		Employee emp2 = new Employee();
		emp2.setName("Balram");
		emp2.setDesignation("Software Developer");
		emp2.setEmpId("2");
		emp2.setSalary(70000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
}


