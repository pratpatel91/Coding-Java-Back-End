package com.prat.RestAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prat.RestAPI.DAO.IEmployeeDAO;
import com.prat.RestAPI.Model.EmployeeADT;

//converting a regular class into a service via annotations
@Service
public class EmployeeCRUDService {

	// autowired = applies to constructors, instance variables and setter functions
	@Autowired
	private IEmployeeDAO interfaceDAO; // EmployeeADTService has-a IEmployeeADT

	public int addEmployee(EmployeeADT empAdtObject) {
		return interfaceDAO.addEmployee(empAdtObject);
	}

	public List<EmployeeADT> getAllEmployees() {
		return interfaceDAO.getAllEmployees();
	}

	public EmployeeADT getSingleEmployee(int empId) {
		return interfaceDAO.getSingleEmployee(empId);
	}

	public int deleteEmployee(int empId) {
		return interfaceDAO.deleteEmployee(empId);
	}

	public int updateEmployee(int empId, EmployeeADT empAdtObject) {
		return interfaceDAO.updateEmployee(empId, empAdtObject);
	}

}
