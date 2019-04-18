package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.converter.AuthorDtoToEntity;
import com.library.converter.AuthorEntityToDto;
import com.library.domain.AuthorEntity;
import com.library.dto.AuthorDto;
import com.library.repository.AuthorRepository;

@Service
public class AuthorService implements IOService<AuthorDto> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorEntityToDto entityToDtoConverter;

    @Autowired
    private AuthorDtoToEntity dtoToEntityConverter;

    @Override
    public List<AuthorDto> getData() {
        List<AuthorDto> authors = new ArrayList<>();
        authorRepository.findAll().forEach(entity -> {
            authors.add(entityToDtoConverter.convert(entity));
        });

        return authors;
    }

    @Override
    public AuthorDto getById(Long id) {
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(id);

        if (authorEntityOptional.isPresent()) {
            return entityToDtoConverter.convert(authorEntityOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public void save(AuthorDto t) {
        authorRepository.save(dtoToEntityConverter.convert(t));
    }

}
