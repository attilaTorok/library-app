package com.library.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.UserDto;
import com.library.repository.repository.domain.UserEntity;

@Component
public class UserDtoToEntity implements Converter<UserDto, UserEntity> {

	@Override
	public UserEntity convert(UserDto source) {
		if (source == null) {
			return null;
		}
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setId(source.getId());
		userEntity.setUsername(source.getUsername());
		userEntity.setPassword(source.getPassword());
		
		return userEntity;
	}

}
