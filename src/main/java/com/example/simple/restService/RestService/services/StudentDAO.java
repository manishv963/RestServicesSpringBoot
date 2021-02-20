package com.example.simple.restService.RestService.services;

import java.util.List;

public interface StudentDAO {

	
	public List<Student> getStudents();
	public Student searchStudent(int rollNo);

	public Student addStudent(Student s);
	
	public Student updateStudent(Student s);
	public Student deleteStudent(Student s) ;
	

}
