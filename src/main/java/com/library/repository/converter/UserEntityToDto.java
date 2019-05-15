package com.library.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.UserDto;
import com.library.repository.repository.domain.UserEntity;

@Component
public class UserEntityToDto implements Converter<UserEntity, UserDto> {

	@Override
	public UserDto convert(UserEntity source) {
		if (source == null) {
			return null;
		}
		
		UserDto userDto = new UserDto();
		
		userDto.setId(source.getId());
		userDto.setUsername(source.getUsername());
		userDto.setPassword(source.getPassword());
		
		return userDto;
	}

}
