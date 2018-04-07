package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return repository.findById(id).get();
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public void delEmployee(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/employee/age/{age}")
	public List<Employee> getEmployeeByAge(@PathVariable("age") Integer age) {
		return repository.findByAge(age);
	}
	
	@PostMapping("/employee/list")
	public void addEmployeeList(@RequestBody List<Employee> list) {
		employeeService.insertList(list);
	}
}
