package com.prat.RestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prat.RestAPI.Model.EmployeeADT;
import com.prat.RestAPI.Service.EmployeeCRUDService;

//converting a regular class into a rest api via annotations
@RestController
//if user goes to localhost:8080/api/employee 
@RequestMapping("/api/employee")
public class EmployeeController {

	// autowired = applies to constructors, instance variables and setter functions
	@Autowired
	private EmployeeCRUDService crudServices; // EmployeeController has-a EmployeeCRUDService

	// ---Creating Add Employee Service ----------//
	// 1. We update IEmployeeDAO class with new abstract function=addEmployee()
	// 2. We update EmployeeDAOImpl class to implement addEmployee()
	// 3. We update EmployeeCRUDService class with a new function=addEmployee()
	// that calls & returns interfaceDAO.addEmployee()
	// 4. We update EmployeeController with new function=addEmployees() that
	// that calls & returns crudServices.addEmployees()
	// 4.1 due to taking data from JSON body we MUST specify empAdtObj with @ReqBody
	// which means that we have to write addEmployee(@RequestBody EmployeeADT empAdtObject)
	// 4.2 due to specifying add service we MUST use Http Post Function

	// Now CONTROLLER -> CRUDSERVICES -> DAOImpl -> IDAO -> ADT
	@PostMapping
	public int addEmployee(@RequestBody EmployeeADT empAdtObject) {
		return crudServices.addEmployee(empAdtObject);
	}

	// ---Creating Get All Employees Service --------------//
	// 1. We update IEmployeeDAO class with new abstract function=getAllEmployees()
	// 2. We update EmployeeDAOImpl class to implement getAllEmployees()
	// 3. We update EmployeeCRUDService class with a new function=getAllEmployees()
	// that calls & returns interfaceDAO.getAllEmployees()
	// 4. We update EmployeeController with new function=getAllEmployees() that
	// that calls & returns crudServices.getAllEmployees()
	// 4.1 due to specifying get/read service we MUST use Http Get Function

	// Now CONTROLLER -> CRUDSERVICES -> DAOImpl -> IDAO -> ADT
	@GetMapping
	public List<EmployeeADT> getAllEmployees() {
		return crudServices.getAllEmployees();
	}

	// --Creating Get Single Employee Per Id Service ------//
	// 1. We update IEmployeeDAO class with new abstract
	// function=getSingleEmployee()
	// 2. We update EmployeeDAOImpl class to implement getSingleEmployee()
	// 3. We update EmployeeCRUDService class with a new function
	// =getSingleEmployee() that calls & returns interfaceDAO.getSingleEmployee()
	// 4. We update EmployeeController with new function=getSingleEmployee()
	// that calls & returns crudServices.getSingleEmployee()
	// 4.1 due to passing id from url we MUST specify id as a @PATH VARIABLE
	// 4.2 to link the id args to the data coming from url we MUST do:
	// @GetMapping(path = "{id}")
	// getSingleEmployee(@PathVariable ("id) int empId)
	// 4.3 due to specifying get/read service we MUST use Http Get Function

	// Now CONTROLLER -> CRUDSERVICES -> DAOImpl -> IDAO -> ADT
	@GetMapping(path = "{id}")
	public EmployeeADT getSingleEmployee(@PathVariable("id") int empId) {
		return crudServices.getSingleEmployee(empId);
	}

	// --Creating Delete Employee Per Id Service ------//
	// 1. We update IEmployeeDAO class with new abstract
	// function=deleteEmployee()
	// 2. We update EmployeeDAOImpl class to implement deleteEmployee()
	// 3. We update EmployeeCRUDService class with a new function
	// =deleteEmployee() that calls & returns
	// interfaceDAO.deleteEmployee()
	// 4. We update EmployeeController with new function=deleteEmployee()
	// that calls & returns crudServices.deleteEmployee()
	// 4.1 due to passing id from url we MUST specify id as a @PATH VARIABLE
	// 4.2 to link the id args to the data coming from url we MUST do:
	// @DeleteMapping(path = "{id}")
	// deleteEmployee(@PathVariable ("id) int empId)
	// 4.3 due to specifying delete service we MUST use Http Delete Function

	// Now CONTROLLER -> CRUDSERVICES -> DAOImpl -> IDAO -> ADT
	@DeleteMapping(path = "{id}")
	public int deleteEmployee(@PathVariable("id") int empId) {
		return crudServices.deleteEmployee(empId);
	}

	// --Creating Update Employee Per Id Service ------//
	// 1. We update IEmployeeDAO class with new abstract
	// function=updateEmployee()
	// 2. We update EmployeeDAOImpl class to implement updateEmployee()
	// 3. We update EmployeeCRUDService class with a new function
	// =updateEmployee() that calls & returns
	// interfaceDAO.updateEmployee()
	// 4. We update EmployeeController with new function=updateEmployee()
	// that calls & returns crudServices.updateEmployee()
	// 4.1 due to passing id from url we MUST specify id as a @PATH VARIABLE
	// 4.2 to link the id args to the data coming from url we MUST do:
	// @PutMapping(path = "{id}")
	// updateEmployee(@PathVariable ("id) int empId, )
	// 4.3 due to taking data from JSON body MUST specify empAdtObj with @ReqBody
	// which means that we have to write updateEmployee(@RequestBody EmployeeADT empAdtObject)
	// 4.4 due to specifying delete service we MUST use Http Put Function

	// Now CONTROLLER -> CRUDSERVICES -> DAOImpl -> IDAO -> ADT
	@PutMapping("/update/{id}")
	public int updateEmployee(@PathVariable("id") int empId, @RequestBody EmployeeADT empAdtObject) {
		return crudServices.updateEmployee(empId, empAdtObject);
	}
}