package com.library.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.domain.BookEntity;
import com.library.dto.BookDto;
import com.library.repository.BookRepository;

@Component
public class BookDtoToEntity implements Converter<BookDto, BookEntity> {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorDtoToEntity authorDtoToEntity;
	
	@Override
	public BookEntity convert(BookDto source) {
		if (source == null) {
			return null;
		}
		
		BookEntity bookEntity = getEntityFromDbOrNew(source);
		
		bookEntity.setAuthor(authorDtoToEntity.convert(source.getAuthor()));
		bookEntity.setTitle(source.getTitle());
		bookEntity.setLoaned(source.isLoaned());
		bookEntity.setReleaseDate(source.getReleaseDate());
		
		return bookEntity;		
	}
	
	private BookEntity getEntityFromDbOrNew(BookDto source) {
		Optional<BookEntity> bookEntityOptional = bookRepository.findById(source.getId());

		if (bookEntityOptional.isPresent()) {
			return bookEntityOptional.get();
		} else {
			return new BookEntity();
		}
	}

}
