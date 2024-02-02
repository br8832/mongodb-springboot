package com.example.mdbspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.Employee;
import com.example.mdbspringboot.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(int salary, String firstname, String lastname) {
		return empRepo.save(new Employee(salary,firstname,lastname));
	}
	public List<Employee> getAll(){return empRepo.findAll();}
	
	public Optional<Employee> get(int id) {
		return empRepo.findById(id);
	}
	public Employee update(int id, int salary, String firstname, String lastname) {
		Optional<Employee> e = empRepo.findById(id);
		Employee emp=null;
		if(e.isPresent()) {
			emp = e.get();
			emp.setFirstname(firstname);
			emp.setLastname(lastname);
			emp.setSalary(salary);
			empRepo.save(emp);
		}
		return emp;		
	}
	public Employee delete(int id) {
		Optional<Employee> e = empRepo.findById(id);
		Employee emp=null;
		if(e.isPresent()) {
			emp=e.get();
			empRepo.delete(emp);
		}
		return emp;
		
	}
}
