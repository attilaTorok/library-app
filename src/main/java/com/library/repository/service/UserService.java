package com.library.repository.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.converter.UserDtoToEntity;
import com.library.repository.converter.UserEntityToDto;
import com.library.repository.dto.UserDto;
import com.library.repository.repository.dao.UserDao;
import com.library.repository.repository.domain.UserEntity;

@Service
public class UserService implements IOService<UserDto> {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDtoToEntity dtoToEntityConverter;
	
	@Autowired
	private UserEntityToDto entityToDtoConverter;
	
	@Override
	public List<UserDto> getData() {
		List<UserDto> users = new ArrayList<>();
		
		userDao.findAll().forEach(user -> {
			users.add(entityToDtoConverter.convert(user));
		});
		
		return users;
	}

	@Override
	public UserDto getById(Long id) {
		Optional<UserEntity> optional = userDao.findById(id);
		
		if (optional.isPresent()) {
			return entityToDtoConverter.convert(optional.get());
		} else {
			return null;
		}
	}

	@Override
	public void save(UserDto t) {
		userDao.save(dtoToEntityConverter.convert(t));		
	}

	@Override
	public void delete(UserDto t) {
		userDao.delete(dtoToEntityConverter.convert(t));			
	}
	
	public UserDto getByUsername(String username) {
		Optional<UserEntity> optional = userDao.findByUsername(username);
		
		if (optional.isPresent()) {
			return entityToDtoConverter.convert(optional.get());
		} else {
			return null;
		}
	}

}
