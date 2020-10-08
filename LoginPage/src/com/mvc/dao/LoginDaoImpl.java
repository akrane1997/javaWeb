package com.mvc.dao;

import java.sql.*;

import com.mvc.controller.*;

public class LoginDaoImpl implements LoginDao{
	
	PreparedStatement ps;
	String query;
	ResultSet rs;
	Connection con=DBConnection.createConnection();
	
	
	
	@Override
	public boolean userLogin(String uname, String pass) {
		query="select * from login where UserName = ? and Password = ?";
		try 
		{
			ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
//				if(uname.equals(rs.getString("UserName")) && pass.equals("Password"))
//				{
//					System.out.println("username:"+uname+"password:"+pass);
//					return true;
//				}
				System.out.println("username:"+uname+"password:"+pass);
				return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}

}
