package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.converter.BookDtoToEntity;
import com.library.converter.BookEntityToDto;
import com.library.domain.BookEntity;
import com.library.dto.BookDto;
import com.library.repository.BookRepository;

@Service
public class BookService implements IOService<BookDto> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookEntityToDto entityToDtoConverter;

    @Autowired
    private BookDtoToEntity dtoToEntityConverter;

    @Override
    public List<BookDto> getData() {
        List<BookDto> books = new ArrayList<>();
        bookRepository.findAll().forEach(entity -> {
            books.add(entityToDtoConverter.convert(entity));
        });
        
        return books;
    }

    @Override
    public BookDto getById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isPresent()) {
            return entityToDtoConverter.convert(bookEntityOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public void save(BookDto t) {
        bookRepository.save(dtoToEntityConverter.convert(t));
    }

}
