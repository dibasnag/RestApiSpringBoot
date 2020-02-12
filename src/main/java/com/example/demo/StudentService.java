package com.example.demo;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepositiory;
	
	
	public List<Student> getAllStudents() {
		return (List<Student>) this.studentRepositiory.findAll();
	}

	public Student getStudent(String id) {
		Student student = studentRepositiory.findById(id).orElse(null);
		return student;
	}
	
	public void addStudent(Student student) {
		studentRepositiory.save(student);
	}

	public void updateStudent(String id, Student student) {
		studentRepositiory.save(student);
	}

	public void deleteStudent(String id) {
		studentRepositiory.deleteById(id);
	}
	
	public List<Student> getStudentsByName(String name) {				
		return (List<Student>) this.studentRepositiory.findByName(name);	
	}


}
