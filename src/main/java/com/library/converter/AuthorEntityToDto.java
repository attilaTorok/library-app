package com.library.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.library.domain.AuthorEntity;
import com.library.dto.AuthorDto;

@Component
public class AuthorEntityToDto implements Converter<AuthorEntity, AuthorDto> {

	@Nullable
	@Override
	public AuthorDto convert(AuthorEntity source) {
		if (source == null) {
			return null;
		}
		
		AuthorDto authorDto = new AuthorDto();
		authorDto.setId(source.getId());
		authorDto.setLastName(source.getLastName());
		authorDto.setFirstName(source.getFirstName());
		authorDto.setDateOfBirth(source.getDateOfBirth());
		
		return authorDto;
	}

}
