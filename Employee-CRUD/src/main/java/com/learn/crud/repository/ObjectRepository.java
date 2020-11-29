package com.learn.crud.repository;

import java.util.List;

public interface ObjectRepository<T> {

	public List<T> retrieveAll();
	public T retrieve(int id);
	
	public void store(T t);
	public default void update(int id, T t) {
		delete(id);
		store(t);
	}

	public void delete(int id);
	public void deleteAll();
}
