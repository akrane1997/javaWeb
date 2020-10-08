package com.mvc.Dao;

import java.util.List;

import com.mvc.Pojo.Employee;

public interface EmployeeDao {
boolean addEmployee(Employee empl);
boolean updateEmployee(Employee empl);
boolean deleteEmployee(int EmpId);
List<Employee> ListOfEmployee();
Employee getEmplyeeById(int EmpId);

}
