package com.maven.Hibernate.Pojo;

import com.maven.Hibernate.Dao.EmployeeDao;
import com.maven.Hibernate.Dao.EmployeeDaoImpl;

public class App {
public static void main(String[] args) {
	EmployeeDao edao=new EmployeeDaoImpl();
	Integer empId1= edao.AddEmployee("akshay", "akshay@gmail.com");
	Integer empId2= edao.AddEmployee("hitesh", "hitesh@gmail.com");
	Integer empId3= edao.AddEmployee("kirti", "kirti@gmail.com");
	
	edao.UpdateEmployee(empId3, "wai");
	edao.ListOfEmployee();
	edao.DeleteEmployee(empId2);
}
}
