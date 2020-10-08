package com.mvc.controller;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
public static Connection createConnection() {
	Connection con = null;
	String url="jdbc:mysql://localhost:3306/StudentRegistration";
	String mysqluname="root";
	String mysqlpwd="Pandurang@123";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, mysqluname, mysqlpwd);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return con;
	
}
}
