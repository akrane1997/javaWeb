package com.mvc.bean;

public class Student {
	private int id;
	private String name;
	private String age;
	private String gender;
	private String address;
	private String email;
	private String password;


	public Student(String name, String age, String gender, String address, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student[name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address + ", email="
				+ email + ", password=" + password + "]";
	}


}
