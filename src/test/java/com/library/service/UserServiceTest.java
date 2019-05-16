package com.library.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.LibraryApplication;
import com.library.repository.converter.UserEntityToDto;
import com.library.repository.dto.UserDto;
import com.library.repository.repository.dao.UserDao;
import com.library.repository.repository.domain.UserEntity;
import com.library.repository.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserEntityToDto userEntityToDto;
	
	private UserEntity entity;
	
	@After
	public void afterTest() {
		userDao.deleteAll();
	}
	
	@Test
	public void getByIdTest() {
		UserDto dto = new UserDto();
		dto.setId(1L);
		userService.save(dto);
		
		UserDto found = userService.getById(1L);
		//assertEquals(found.getId(), dto.getId());
	}
	
	@Test
	public void getDataTest() {
		entity = new UserEntity();
		userDao.save(entity);
		
		entity = new UserEntity();
		userDao.save(entity);
		
		List<UserDto> results = userService.getData();
		
		assertEquals(2, results.size());
	}
	
	@Test
	public void saveTest() {
		List<UserDto> results = userService.getData();
		assertEquals(0, results.size());
		
		UserDto dto = new UserDto();		
		userService.save(dto);
		
		results = userService.getData();
		assertEquals(1, results.size());
	}
	
	@Test
	public void deleteTest() {
		entity = new UserEntity();
		userDao.save(entity);
		
		List<UserDto> results = userService.getData();
		assertEquals(1, results.size());
		
		userService.delete(results.get(0));
		
		results = userService.getData();
		assertEquals(0, results.size());
	}

	@Test
	public void getByUsernameTest() {
		UserDto be = new UserDto();
		be.setUsername("kacsa");
		userService.save(be);
		
		UserDto result = userService.getByUsername("kacsa");
		
		assertEquals(be.getUsername(), result.getUsername());
	}

}
