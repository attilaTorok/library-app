package com.library.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.LibraryApplication;
import com.library.repository.converter.UserEntityToDto;
import com.library.repository.dto.UserDto;
import com.library.repository.repository.domain.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class UserEntityToDtoTest {

	@Autowired
	UserEntityToDto userEntityToDto;
	
	@Test
	public void convertTest() {
		
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setUsername("user");
		entity.setPassword("pass");
		
		UserDto result = userEntityToDto.convert(entity);
		
		assertEquals(entity.getId(), result.getId());
		assertEquals(entity.getUsername(), result.getUsername());
		assertEquals(entity.getPassword(), result.getPassword());
	}
	
}
