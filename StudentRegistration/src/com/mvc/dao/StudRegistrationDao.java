package com.mvc.dao;

import java.util.List;

import com.mvc.bean.Student;

public interface StudRegistrationDao {
boolean addStudent(Student stud);
boolean updateStudent(Student stud);
List<Student> ListOfStudent();
Student getStudByEmail(String email);
}
