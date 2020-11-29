package com.learn.crud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.learn.crud.entity.Employee;

@Repository
@Qualifier("mongodb")
public class MongoEmployeeRepository implements ObjectRepository<Employee> {

	@Autowired
	private MongoTemplate mongoTemp;

	@Override
	public List<Employee> retrieveAll() {
		return mongoTemp.findAll(Employee.class);
	}

	@Override
	public Employee retrieve(int id) {
		return mongoTemp.findById(id, Employee.class);
	}

	@Override
	public void store(Employee employee) {
		mongoTemp.insert(employee);
	}

	@Override
	public void delete(int id) {
		mongoTemp.remove(retrieve(id));
	}

	@Override
	public void deleteAll() {
		mongoTemp.dropCollection(Employee.class);
	}
}
