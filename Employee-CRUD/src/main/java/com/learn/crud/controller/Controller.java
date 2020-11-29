package com.learn.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.crud.entity.Employee;
import com.learn.crud.service.EmployeeService;

@RestController
@RequestMapping("/rest/employees")
public class Controller {

	@Autowired
	private EmployeeService empServ;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return empServ.getAllEmployees();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int id) {
		return empServ.getEmployee(id);
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int id) {
		empServ.delete(id);
	}
	
	@RequestMapping(value = "/all/delete", method = RequestMethod.DELETE)
	public void deleteAll() {
		empServ.deleteAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public void insertEmployee(@RequestBody Employee employee) {
		empServ.addEmployee(employee);
	}
	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		empServ.updateEmployee(id, employee);
	}
}
