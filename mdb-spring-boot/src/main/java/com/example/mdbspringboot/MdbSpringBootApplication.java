package com.example.mdbspringboot;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mdbspringboot.model.Employee;
import com.example.mdbspringboot.model.GroceryItem;
import com.example.mdbspringboot.repository.CustomItemRepository;
import com.example.mdbspringboot.repository.EmployeeRepository;
import com.example.mdbspringboot.repository.ItemRepository;
import com.example.mdbspringboot.services.EmployeeService;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner{
	
	
	@Autowired 
	EmployeeService empService;
	List<Employee> list = new ArrayList<Employee>();

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}
	
	public void run(String... args) {
		
		System.out.println("\n-------------------Save ---------------------------");
		//empService.save(23000, "Marco", "Antonio");
		//empService.save(0,"Bill","Nye");
		System.out.println("\n-------------------Display All---------------------------");
		list = empService.getAll();
		for(Employee e:list) {
			System.out.println(e);
		}
		System.out.println("\n-------------------Update---------------------------");
		empService.update(3, 1000000,"Bryan", "Rodriguez");
		System.out.println("\n-------------------getOne---------------------------");
		System.out.println(empService.get(3));
		System.out.println("\n-------------------NOW delete---------------------------");
		System.out.println(empService.delete(4));
		list = empService.getAll();
		for(Employee e:list) {
			System.out.println(e);
		}
	}
	
	
}

