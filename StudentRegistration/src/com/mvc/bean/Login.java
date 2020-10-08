package com.mvc.bean;

public class Login {
	private String EmailId;
	private String password;
	public String getUsername() {
		return EmailId;
	}
	public void setUsername(String EmailId) {
		this.EmailId = EmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
