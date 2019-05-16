package com.library.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.UserDto;
import com.library.repository.repository.domain.UserEntity;

/**
 * {@link com.library.repository.converter.UserDtoToEntity UserDtoToEntity} is describing a Java class that can perform
 *  {@link com.library.repository.dto.UserDto UserDto}-to-{@link com.library.repository.repository.domain.UserEntity UserEntity} conversions.
 * 
 * 
 * @author Török Attila
 *
 */
@Component
public class UserDtoToEntity implements Converter<UserDto, UserEntity> {

	/**
	 * Convert a {@link com.library.repository.dto.UserDto UserDto} to {@link com.library.repository.repository.domain.UserEntity UserEntity}.
	 * @param source the BookDto which need to be converted.
	 */
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
