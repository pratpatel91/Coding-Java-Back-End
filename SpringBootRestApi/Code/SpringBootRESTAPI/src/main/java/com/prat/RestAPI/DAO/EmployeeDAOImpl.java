package com.prat.RestAPI.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prat.RestAPI.Model.EmployeeADT;

//converting a regular class into a repo via annotations
@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	// EmployeeDAOImpl has-a list of employeeADTObjects
	List<EmployeeADT> listOfEmployees = new ArrayList<>();

	@Override
	public int addEmployee(EmployeeADT empAdtObject) {
		listOfEmployees.add(empAdtObject);
		return 1;
	}

	@Override
	public List<EmployeeADT> getAllEmployees() {
		return listOfEmployees;
	}

	@Override
	public EmployeeADT getSingleEmployee(int empId) {
		EmployeeADT foundEmployee = null;
		// iterate the list to find the correct adt object that has the same empId
		for (int i = 0; i <= listOfEmployees.size() - 1; i++) {
			if (listOfEmployees.get(i).getEmpId() == empId) {
				foundEmployee = listOfEmployees.get(i);
				return foundEmployee; // returning emp adt object if its found in the list
			}
		}
		return foundEmployee; // returning null if the emp adj object didnt exist in the list
	}

	@Override
	public int deleteEmployee(int empId) {
		EmployeeADT employeeToDelete = null;

		// iterate the list to find the correct adt object that has the same empId
		for (int i = 0; i <= listOfEmployees.size() - 1; i++) {
			if (listOfEmployees.get(i).getEmpId() == empId) {
				employeeToDelete = listOfEmployees.get(i);
			}
		}

		if (employeeToDelete != null) {
			listOfEmployees.remove(employeeToDelete); // removing employee adt object from list
			return 1; // returning 1 if the emp adt object was deleted from the list
		} else {
			return 0; // returning 0 if the emp adj object didnt exist in the list
		}
	}

	@Override
	public int updateEmployee(int empId, EmployeeADT empAdtObject) {

		EmployeeADT employeeToUpdate = null;

		// iterate the list to find the correct adt object that has the same empId
		for (int i = 0; i <= listOfEmployees.size() - 1; i++) {
			if (listOfEmployees.get(i).getEmpId() == empId) {
				employeeToUpdate = listOfEmployees.get(i);
			}
		}
		if (employeeToUpdate != null) {
			int newEmpId = empAdtObject.getEmpId();
			String newEmpName = empAdtObject.getEmpName();
			employeeToUpdate.setEmpId(newEmpId);
			employeeToUpdate.setEmpName(newEmpName);
			return 1; // returning 1 if the emp adt object was deleted from the list
		} else {
			return 0; // returning 0 if the emp adj object didnt exist in the list
		}
	}

}
