package com.mvc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;

import com.mvc.Pojo.Employee;
import com.mvc.Controller.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	PreparedStatement ps;
	String query;
	int row;
	ResultSet rs;
	Connection con = DBConnection.createConnection();




	public boolean addEmployee(Employee empl) {
		query="insert into Employee(EmpName,EmpEmail,EmpAddress)"
				+"values(?,?,?)";

		try
		{
			ps = con.prepareStatement(query);
			ps.setString(1, empl.getEmpName());
			ps.setString(2, empl.getEmpEmail());
			ps.setString(3, empl.getEmpAddress());

			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		if(row>0)
			return true;
		else
			return false;
	}


	public boolean updateEmployee(Employee empl) {
		query="update Employee set EmpName=?, EmpEmail where Empid=?"
				+"values(?,?,?,?,?,?)";

		try
		{
			ps = con.prepareStatement(query);
			ps.setString(1, empl.getEmpName());
			ps.setString(2, empl.getEmpEmail());
			ps.setString(3, empl.getEmpAddress());
			ps.setInt(4, empl.getEmpId());
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		if(row>0)
			return true;
		else
			return false;
	}


	public boolean deleteEmployee(int EmpId) {
		query="delete from Employee where EmpId=?";
		try
		{
			ps=con.prepareStatement(query);
			ps.setInt(1,EmpId);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}


	public List<Employee> ListOfEmployee() {
		query="select * from Employee";
		List<Employee> list=new ArrayList<>();
		Employee empl;
		try
		{
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				empl=new Employee(rs.getString("EmpName"),rs.getString("EmpEmail"),rs.getString("EmpAddress"));
				empl.setEmpId(rs.getInt("EmpId"));
				list.add(empl);

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}


	public Employee getEmplyeeById(int EmpId) {
		query="select * from Employee where EmpId=?";
		Employee empl=null;
		try
		{
			ps=con.prepareStatement(query);
			ps.setInt(1,EmpId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				empl=new Employee(rs.getString("EmpName"),rs.getString("EmpEmail"),rs.getString("EmpAddress"));
				empl.setEmpId(rs.getInt("EmpId"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return empl;
	}

}
