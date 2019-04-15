package com.library.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.library.domain.AuthorEntity;
import com.library.dto.AuthorDto;
import com.library.repository.AuthorRepository;

@Component
public class AuthorDtoToEntity implements Converter<AuthorDto, AuthorEntity> {

	@Autowired
	private AuthorRepository authorRepository;

	@Nullable
	@Override
	public AuthorEntity convert(AuthorDto source) {
		if (source == null) {
			return null;
		}

		AuthorEntity authorEntity = getEntityFromDbOrNew(source);

		authorEntity.setLastName(source.getLastName());
		authorEntity.setFirstName(source.getFirstName());
		authorEntity.setDateOfBirth(source.getDateOfBirth());

		return authorEntity;
	}

	private AuthorEntity getEntityFromDbOrNew(AuthorDto source) {
		Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(source.getId());

		if (authorEntityOptional.isPresent()) {
			return authorEntityOptional.get();
		} else {
			return new AuthorEntity();
		}
	}

}
