package com.library.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.LibraryApplication;
import com.library.repository.repository.dao.UserDao;
import com.library.repository.repository.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
	@After
	public void tearDown() {
		userDao.deleteAll();
	}
	
	@Test
	public void getByUsernameTest() {
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setUsername("user");
		
		//userDao.save(entity);
		
		//UserEntity result = userDao.findByUsername("user").get();
		
		//assertEquals(entity.getUsername(), result.getUsername());
	}
}
