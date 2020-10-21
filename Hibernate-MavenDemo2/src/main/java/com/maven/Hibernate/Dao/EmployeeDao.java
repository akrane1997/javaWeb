package com.maven.Hibernate.Dao;



public interface EmployeeDao {
Integer AddEmployee(String name,String email );
void UpdateEmployee(Integer id,String name);
void DeleteEmployee(Integer id);
void ListOfEmployee();
}
