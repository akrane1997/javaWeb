package com.mvc.dao;

import java.sql.*;

import com.mvc.controller.*;

public class LoginDaoImpl implements LoginDao{
	
	PreparedStatement ps;
	String query;
	ResultSet rs;
	Connection con=DBConnection.createConnection();
	
	
	
	@Override
	public boolean StudLogin(String email, String pass) {
		query="select StudEmail,StudPassword from student where StudEmail=? and StudPassword=?";
		try 
		{
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				if(email.equals(rs.getString("StudEmail")) && pass.equals((rs.getString("StudPassword"))))
				{
					System.out.println("username: "+email+"password: "+pass);
					return true;
				}
//				System.out.println("username:"+email+"password:"+pass);
//				return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}



	@Override
	public boolean TheacherLogin(String email, String pass) {
		query="select TeacherEmailId,TeacherPassword from teacher where TeacherEmailId=? and TeacherPassword=?";
		try 
		{
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				if(email.equals(rs.getString("TeacherEmailId")) && pass.equals((rs.getString("TeacherPassword"))))
				{
					System.out.println("username: "+email+"password: "+pass);
					return true;
				}

			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}

}
