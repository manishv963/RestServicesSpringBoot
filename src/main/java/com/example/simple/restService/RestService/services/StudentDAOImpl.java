package com.example.simple.restService.RestService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentDAOImpl implements StudentDAO{

	private List<Student> studentsList = new ArrayList<Student>();
	public StudentDAOImpl() {
		
		
	}
	public StudentDAOImpl(int rollNumber,int marks,String name) {
		Student s = new Student();
		s.setName(name);
		s.setRollNumber(rollNumber);
		s.setMarks(marks);
		this.studentsList.add(s);
	}
	@Override
	public List<Student> getStudents() {
		
		// TODO Auto-generated method stub
		return this.studentsList;
	}
	
	public Student searchStudent(int rollNo) {
		Student s= null;
		for(Student s1:this.studentsList) {
			if(s1.getRollNumber().equals(rollNo)) {
				s = s1;
				break;
			}
		}
		return s;
	}

	public Student addStudent(Student s) {
		this.studentsList.add(s);
		return s;
		
	}
	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
			
		for(Student s1:this.studentsList) {
			if(s.getRollNumber() == s1.getRollNumber()) {
				this.studentsList.remove(s1);
				this.addStudent(s);
				break;
			}
			
		}
		return s;
	}
	

	@Override
	public Student deleteStudent(Student s) {
		// TODO Auto-generated method stub
			if(this.studentsList.contains(s)) {
			this.studentsList.remove(s);	
			}
		return s;
	}
	

}
