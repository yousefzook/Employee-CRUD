package com.learn.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.crud.entity.Employee;
import com.learn.crud.repository.ObjectRepository;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("fake data")
	private ObjectRepository<Employee> employeeRepo;
	
	public List<Employee> getAllEmployees() {
		return employeeRepo.retrieveAll();
	}

	public Employee getEmployee(int id) {
		return employeeRepo.retrieve(id);
	}
	
	public void addEmployee(Employee emp) {
		employeeRepo.store(emp);
	}
	
	public void updateEmployee(int id, Employee emp) {
		employeeRepo.update(id, emp);
	}
	
	public void delete(int id) {
		employeeRepo.delete(id);
	}
	
	public void deleteAll() {
		employeeRepo.deleteAll();
	}
}
