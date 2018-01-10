package com.aug.db.handle;

import java.util.List;

public interface DbHandleAPI<T> {

	boolean create(T object);
	
	boolean update(T object);
	
	boolean delete(T object);
	
	List<T> getAll();
}
