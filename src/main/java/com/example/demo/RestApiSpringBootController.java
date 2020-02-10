package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class RestApiSpringBootController {
	
	@Autowired
	private StudentService studentService;
	
	//@ApiOperation is a swagger annotation, which is used to provide data to swagger about the endpoint
	@RequestMapping(method=RequestMethod.GET, value="/testurl")
	@ApiOperation(value="This is a test API endpoint",
					notes="This API is for test",
					response=String.class)
	public String test() {
	 return "Controller Test Successful";
	}	
	
	//@PostMapping("/studentlist")
	@RequestMapping(method=RequestMethod.POST, value="/studentlist")
	public List<Student> getAllStudents() {
	 return studentService.getAllStudents();
	}
	
	
	//@ApiOperation is a swagger annotation, which is used to provide data to swagger about the endpoint
	//@ApiParam is a swagger annotation, which is used to provide data about api parameters
	@RequestMapping(method=RequestMethod.POST, value="/studentlist/{id}")
	@ApiOperation(value="This is used to retrieve information about a single student",
					notes="The Id of the student has to be provided to retrieve the data",
					response=Student.class)
	public Student getStudent(@ApiParam(value="ID of the student whose information is required.", required = true)
							  @PathVariable String id) {
	 return studentService.getStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addstudent")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		String response = "{\"success\": true, \"message\": Student has been added successfully.}";
		return response;
	}
	

	//@PutMapping("/topics/{id}")
	@RequestMapping(method=RequestMethod.PUT, value="/studentlist/{id}")
	public String updateTopic(@RequestBody Student student, @PathVariable String id) {
		studentService.updateStudent(id, student);
		String response = "{\"success\": true, \"message\": Student has been updated successfully.}";
		return response;
	}
	
	//@RequestMapping(method=RequestMethod.DELETE, value="/studentlist/{id}")
	@DeleteMapping("/studentlist/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		String response = "{\"success\": true, \"message\": Student has been deleted successfully.}";
		return response;
	}
	
	//@ApiOperation is a swagger annotation, which is used to provide data to swagger about the endpoint
	//@ApiParam is a swagger annotation, which is used to provide data about api parameters
	@RequestMapping(method=RequestMethod.POST, value="/studentname/{name}",  produces={"application/json"})
	@ApiOperation(value="This is used to search students by name",
					notes="The name of the student has to be provided to retrieve the data",
					response=Student.class)
	public String getStudentByName
	(@ApiParam(value="Name of the student whose information is required.", required = true)
	 @PathVariable String name) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Student> studentList = studentService.getStudentsByName(name);
		
		if(!studentList.isEmpty())
		{
			try
			{
				return mapper.writeValueAsString(studentList);
			}
			catch (JsonProcessingException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "JSON Conversion Error";
			}
		}
		else
		{
			String response = "{\"ERROR\": Student Not Found.}";
			return response;
		}
	 
	 
	}	
	

}
