package com.lt.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController

public class EmployeeController {
	@PostMapping("/add")
	public ResponseEntity<Flux<Employee>> add(@RequestBody Mono<Employee> employee){
		
		return new ResponseEntity<Flux<Employee>>(HttpStatus.NOT_FOUND);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Flux<Employee>> updateEmployee(@PathVariable long id,
			@RequestBody Mono<Employee> employee){
		return new ResponseEntity<Flux<Employee>>(employee.flux(), HttpStatus.OK);
	}
	@GetMapping("/getall")
	public Flux<List<Employee>> getAll(){
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("Employee",123,"Pune","9890898777","One"));
		employees.add(new Employee("Employee",300,"Mumbai","9890898700","Two"));
		return Flux.just(employees);
	}
}
