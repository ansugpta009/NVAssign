package com.umbertoemonds.societe;

import org.springframework.data.repository.CrudRepository;

import com.umbertoemonds.societe.model.Employe;


public interface EmployeeRepository extends CrudRepository<Employe, Integer>{

	
	
}
