package spring.mvc.service;

import java.util.List;

import spring.mvc.model.Employee;


public interface EmployeeService {

	public void addEmployee(Employee employee);
	 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee updateEmployee(Employee employee);
 
    public Employee getEmployee(int employeeid);
}
