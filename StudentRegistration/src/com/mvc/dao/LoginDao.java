package com.mvc.dao;

public interface LoginDao {
	
	boolean StudLogin(String email,String pass);
	boolean TheacherLogin(String email,String pass);
}
