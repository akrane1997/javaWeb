package com.mvc.controller;

import java.sql.*;

public class DBConnection {
public static Connection createConnection() {
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/loginPage";
	String mysqluname="root";
	String mysqlpwd="Pandurang@123";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url, mysqluname, mysqlpwd);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return con;	
}
	
	
}
