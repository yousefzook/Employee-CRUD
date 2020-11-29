package com.learn.crud.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.learn.crud.entity.Employee;

@Repository
@Qualifier("fake data")
public class FakeEmployeeRepository implements ObjectRepository<Employee> {

	private static HashMap<Integer, Employee> employees;
	private static int id = 0;
	FakeEmployeeRepository(){
		employees = new HashMap<>();
		// add default fake data
		employees.put(++id, new Employee(id, "Yousef", "22/12/1996"));
		employees.put(++id, new Employee(id, "Ahmed", "05/06/1994"));
	}

	@Override
	public List<Employee> retrieveAll() {
		return new ArrayList<>(employees.values());
	}

	@Override
	public Employee retrieve(int id) {
		return employees.get(id);
	}

	@Override
	public void store(Employee employee) {
		employees.put(employee.getId(), employee);
	}

	@Override
	public void delete(int id) {
		employees.remove(id);
	}

	@Override
	public void deleteAll() {
		employees = new HashMap<>();
	}

}
