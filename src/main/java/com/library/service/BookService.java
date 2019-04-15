package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BookDto;
import com.library.repository.BookRepository;

@Service
public class BookService implements IOService<BookDto> {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookEntityToDto bookEntityToDto;
	
	@Autowired
	private BookDtoToEntity bookDtoToEntity;
	
	@Override
	public List<BookDto> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(BookDto t) {
		// TODO Auto-generated method stub
		
	}

}
