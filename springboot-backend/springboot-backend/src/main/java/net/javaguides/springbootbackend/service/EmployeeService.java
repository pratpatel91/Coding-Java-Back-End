package net.javaguides.springbootbackend.service;

import java.util.List;

import net.javaguides.springbootbackend.model.Employee;

public interface EmployeeService
{
	Employee saveEmployee(Employee employeeObject);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployeeById(Employee employeeObject, long id);
	void deleteEmployeeById(long id);
}
