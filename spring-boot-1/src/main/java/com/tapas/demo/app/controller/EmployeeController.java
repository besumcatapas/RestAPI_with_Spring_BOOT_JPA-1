package com.tapas.demo.app.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tapas.demo.app.entity.Employee;
import com.tapas.demo.app.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;

	@RequestMapping(value = "/users")
	@GetMapping
	public List<Employee> getAllEmployee(){
		
		List<Employee> empList = repo.findAll();
		//List<Employee> empList = new ArrayList<Employee>();
		//empList.add(new Employee(1, "Tapas"));
		return empList;
	}
	
	@RequestMapping(value = "/users/{user}")
	@GetMapping
	public Optional<Employee> getEmployee(@PathVariable int user){
		
		Optional<Employee> empList = repo.findById(user);
		
		return empList;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<?> createUsers(@RequestBody Employee emp) {
		Employee e = repo.save(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(e.getEmpId()).toUri();
		
		return  ResponseEntity.created(location).build();
		
	}
}
