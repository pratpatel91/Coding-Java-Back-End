package com.prat.RestAPI.Model;

public class EmployeeADT {

	// ---Instance Variables -----//
	private int empId;
	private String empName;

	// ------Getter & Setter Functions for Instance Variables -----//
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
