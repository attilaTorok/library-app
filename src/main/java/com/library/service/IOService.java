package com.library.service;

import java.util.List;

public interface IOService<T> {
	
	/**
	 * 
	 * @return
	 */
	List<T> getData();
	
	/**
	 * 
	 */
	T getById(Long id);
	
	/**
	 * 
	 */
	void save(T t);
}
