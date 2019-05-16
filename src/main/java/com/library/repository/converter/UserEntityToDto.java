package com.library.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.UserDto;
import com.library.repository.repository.domain.UserEntity;

/**
 * {@link com.library.repository.converter.UserEntityToDto BookDtoToEntity} is describing a Java class that can perform
 *  {@link com.library.repository.repository.domain.UserEntity UserEntity}-to-{@link com.library.repository.dto.UserDto UserDto} conversions.
 * 
 * 
 * @author Török Attila
 *
 */
@Component
public class UserEntityToDto implements Converter<UserEntity, UserDto> {

	/**
	 * Convert a {@link com.library.repository.repository.domain.UserEntity UserEntity} to {@link com.library.repository.dto.UserDto UserDto}.
	 * @param source the BookDto which need to be converted.
	 */
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
