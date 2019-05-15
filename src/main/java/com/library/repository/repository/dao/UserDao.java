package com.library.repository.repository.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.library.repository.repository.domain.UserEntity;

public interface UserDao extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
	
}
