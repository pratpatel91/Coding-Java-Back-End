package net.javaguides.springbootbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
	// dependency (EmployeeController obj has-a EmployeeService obj)
	private EmployeeService employeeService;

	// constructor to inject dependency (EmployeeController obj has-a
	// EmployeeService obj)
	public EmployeeController(EmployeeService employeeService)
	{
		super();
		this.employeeService = employeeService;
	}

	//build delete employee REST API Service
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id)
	{
		//deletes the employee from the database
		employeeService.deleteEmployeeById(id);
		
		return new ResponseEntity<String>("employee deleted successfully", HttpStatus.OK);
	}
	
	
	
	
	// build update employee REST API Service
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") long id,
			@RequestBody Employee empObject)
	{
		Employee javaObject = employeeService.updateEmployeeById(empObject, id);
		return new ResponseEntity<Employee>(javaObject, HttpStatus.OK);
	}

	// build get employee by id REST API Service
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
	{
		Employee javaObject = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(javaObject, HttpStatus.OK);
	}

	// build create employee REST API Service
	// Request body annotation binds JSON object to Java object
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employeeObject)
	{
		Employee javaObject = employeeService.saveEmployee(employeeObject);
		return new ResponseEntity<Employee>(javaObject, HttpStatus.CREATED);
	}

	// build get all employees REST API Service
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
}
