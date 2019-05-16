package com.library.repository.repository.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.library.repository.repository.domain.UserEntity;

/**
 * UserDao is an interface for generic CRUD operations on a 
 * {@link com.library.repository.repository.domain.UserEntity UserEntity} repository.
 * 
 * @author Török Attila
 */
public interface UserDao extends CrudRepository<UserEntity, Long> {

	/**
	 * Perform a search by username in the database.
	 * 
	 * @param username the username which need to be found
	 * @return an optional about the entity
	 * @see java.util.Optional Optional
	 */
	Optional<UserEntity> findByUsername(String username);
	
}
