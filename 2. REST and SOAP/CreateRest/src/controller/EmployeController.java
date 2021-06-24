package com.umbertoemonds.societe.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.umbertoemonds.societe.EmployeeRepository;
import com.umbertoemonds.societe.model.Employe;


import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="/employees")
public class EmployeController {
	
	@Autowired private EmployeeRepository employeeRepository;
	
	// afficher tous les employés
	@GetMapping("/all")
	@ResponseBody Iterable<Employe> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	// créer un nouvel employé
	@PostMapping("/new")
	Employe newEmploye(@RequestBody Employe newEmployee){
		return employeeRepository.save(newEmployee);
	}
	
	// remplacer un employé
	@PutMapping("/update/{id}")
	Employe editEmploye(@RequestBody Employe newEmployee, @PathVariable int id) {
		return employeeRepository.findById(id)
				.map(employee -> {
			        employee.setName(newEmployee.getName());
			        employee.setJob(newEmployee.getJob());
			        return employeeRepository.save(employee);
			      })
			      .orElseGet(() -> {
			        newEmployee.setId(id);
			        return employeeRepository.save(newEmployee);
			      });
	}
	
	// supprimer un employé
	@DeleteMapping("/delete/{id}")
	void deleteEmploye(@PathVariable Integer id){
		employeeRepository.deleteById(id);
	}
	
}