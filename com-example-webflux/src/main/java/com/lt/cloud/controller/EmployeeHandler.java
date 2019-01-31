package com.lt.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.lt.cloud.pojo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeHandler {
	public Mono<ServerResponse> findAll(ServerRequest request){
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee("Employee",123,"Pune","9890898777","One"));
		employees.add(new Employee("Employee",300,"Mumbai","9890898700","Two"));
		Flux<Employee> emp=Flux.fromIterable(employees);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).
				body(emp, Employee.class);
	}
}
