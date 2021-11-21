package com.prat.RestAPI.DAO;

import java.util.List;

import com.prat.RestAPI.Model.EmployeeADT;

public interface IEmployeeDAO {
	int addEmployee(EmployeeADT adtObject);

	List<EmployeeADT> getAllEmployees();

	EmployeeADT getSingleEmployee(int empId);

	int deleteEmployee(int empId);

	int updateEmployee(int empId, EmployeeADT empAdtObject);

}
