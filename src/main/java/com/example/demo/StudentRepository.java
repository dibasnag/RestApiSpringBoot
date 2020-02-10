package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
	
	//Custom filter. Syntax - findBy[field-name]()
	public List<Student> findByName(String name);
	
}