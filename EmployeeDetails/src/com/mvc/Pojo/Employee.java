package com.mvc.Pojo;

public class Employee {
	private int EmpId;
	private String EmpName;
	private String EmpEmail;
	private String EmpAddress;
	
	
	public Employee(String empName, String empEmail, String empAddress) {
		super();
		EmpName = empName;
		EmpEmail = empEmail;
		EmpAddress = empAddress;
	}
	


	public Employee(int empId, String empName, String empEmail, String empAddress) {
		super();
		EmpId = empId;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpAddress = empAddress;
	}



	public int getEmpId() {
		return EmpId;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public String getEmpEmail() {
		return EmpEmail;
	}


	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}


	public String getEmpAddress() {
		return EmpAddress;
	}


	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}
	
	
}
