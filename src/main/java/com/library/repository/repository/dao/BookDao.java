package com.library.repository.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.repository.repository.domain.BookEntity;

/**
 * BookDao is an interface for generic CRUD operations on a 
 * {@link com.library.repository.repository.domain.BookEntity BookEntity} repository.
 * 
 * @author Török Attila
 */
public interface BookDao extends CrudRepository<BookEntity, Long> {

	/**
	 * Perform a search by title while case like is not important.
	 * 
	 * @param title the title which need to be found
	 * @return the found book entities
	 */
	List<BookEntity> findByTitleIgnoreCaseLike(String title);
	
}
