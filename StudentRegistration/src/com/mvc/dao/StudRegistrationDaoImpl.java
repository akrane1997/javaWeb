package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.Student;
import com.mvc.controller.DBConnection;

public class StudRegistrationDaoImpl implements StudRegistrationDao{
	
	PreparedStatement ps;
	String query;
	int row;
	ResultSet rs;
	Connection con = DBConnection.createConnection();
	

	@Override
	public boolean addStudent(Student stud) {
		query="insert into student(StudName,StudAge,StudGender,StudAddress,StudEmail,StudPassword)"
				+"values(?,?,?,?,?,?)";
		
		try
		{
			ps = con.prepareStatement(query);
			ps.setString(1, stud.getName());
			ps.setString(2, stud.getAge());
			ps.setString(3, stud.getGender());
			ps.setString(4, stud.getAddress());
			ps.setString(5, stud.getEmail());
			ps.setString(6, stud.getPassword());
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


	@Override
	public boolean updateStudent(Student stud) {
		query="update student set StudName=?, StudAge=?, StudGender=?, StudAddress=?, StudEmail=?, StudPassword=? where id=?"
				+"values(?,?,?,?,?,?)";
		
		try
		{
			ps = con.prepareStatement(query);
			ps.setString(1, stud.getName());
			ps.setString(2, stud.getAge());
			ps.setString(3, stud.getGender());
			ps.setString(4, stud.getAddress());
			ps.setString(5, stud.getEmail());
			ps.setString(6, stud.getPassword());
			ps.setInt(7, stud.getId());
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


	public List<Student> ListOfStudent() {
		query="select * from student";
		List<Student> list=new ArrayList<>();
		Student stud;
		try
		{
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				stud=new Student(rs.getString("StudName"),rs.getString("StudAge"),rs.getString("StudGender"),rs.getString("StudAddress"),rs.getString("StudEmail"),rs.getString("StudPassword"));
				stud.setId(rs.getInt("id"));
				list.add(stud);
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return list;
	}


	public Student getStudByEmail(String email) {
		query="select * from student where StudEmail=?";
		Student stud=null;
		try
		{
			ps=con.prepareStatement(query);
			ps.setString(1,email);
			rs=ps.executeQuery();
			while(rs.next())
			{

				stud=new Student(rs.getString("StudName"),rs.getString("StudAge"),rs.getString("StudGender"),rs.getString("StudAddress"),rs.getString("StudEmail"),rs.getString("StudPassword"));
				stud.setId(rs.getInt("id"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return stud;
	}

}
