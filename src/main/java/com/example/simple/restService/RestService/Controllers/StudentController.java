package com.example.simple.restService.RestService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple.restService.RestService.services.Student;
import com.example.simple.restService.RestService.services.StudentDAOImpl;
@RestController

public class StudentController {

	@Autowired
	private StudentDAOImpl studentService;
@GetMapping("/home")
public String home() {
	Student s = new Student();
	s.setName("Manish");
	s.setRollNumber(1);
	s.setMarks(80);
	studentService.addStudent(s);
	return "Yeh apna home page hai";
}

@GetMapping("/students")
public List<Student> getStudents() {
	
	return studentService.getStudents();
}


@GetMapping("/students/{rollNumber}")
public Student getStudent(@PathVariable int rollNumber) {
	System.out.println(rollNumber);
	return studentService.searchStudent(rollNumber);
}
@PostMapping("/students")
public Student addStudent(@RequestBody Student s) {
	System.out.println(s.toString());
	studentService.addStudent(s);
	return s;
}
@PutMapping("/students")
public Student updateStudent(@RequestBody Student s) {
	System.out.println(s.toString());
	studentService.updateStudent(s);
	return s;
}

@DeleteMapping
public Student deleteStudent(@RequestBody Student s) {
	System.out.println(s.toString());
	studentService.deleteStudent(s);
	return s;
}
}
