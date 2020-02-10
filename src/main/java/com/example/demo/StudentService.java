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
	
		//	private List<Student> students = new ArrayList<>(Arrays.asList(
		//			new Student("1", "Student One", "School1", "STD I"),
		//			new Student("2", "Student Two", "School2", "STD II"),
		//			new Student("3", "Student Three", "School3", "STD III")
		//			));
	
	public List<Student> getAllStudents() {
		//return students;
		
		//List<Student> students = new ArrayList<>();
		//studentRepositiory.findAll().forEach(students::add);
		//return students;
		
		return (List<Student>) this.studentRepositiory.findAll();
	}

	public Student getStudent(String id) {
		//return students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
		//return studentRepositiory.findById(id);
		Student student = studentRepositiory.findById(id).orElse(null);
		return student;
	}
	
	public void addStudent(Student student) {
		//students.add(student);
		studentRepositiory.save(student);
	}

	public void updateStudent(String id, Student student) {
		//		for(int i=0; i<students.size(); i++) {
		//			Student s = students.get(i);
		//			if(s.getId().equals(id)) {
		//				students.set(i, student);
		//				return;
		//			}
		//		}
		
		//If only some fields to be updated are provided along with ID.
		//Then first find the object then modify it and then save it.
		//Student student = studentRepositiory.findById(id).orElse(null); 
		//student.setName("NEW NAME"); 
		//studentRepositiory.save(student);
		
		studentRepositiory.save(student);
	}

	public void deleteStudent(String id) {
		//students.removeIf(s -> s.getId().equals(id));
		studentRepositiory.deleteById(id);
	}
	
	public List<Student> getStudentsByName(String name) {				
		return (List<Student>) this.studentRepositiory.findByName(name);	
	}


}
