package com.library.repository.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.BookDto;
import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;

/**
 * {@link com.library.repository.converter.BookDtoToEntity BookDtoToEntity} is describing a Java class that can perform
 *  {@link com.library.repository.dto.BookDto BookDto}-to-{@link com.library.repository.repository.domain.BookEntity BookEntity} conversions.
 * 
 * 
 * @author Török Attila
 *
 */
@Component
public class BookDtoToEntity implements Converter<BookDto, BookEntity> {

	@Autowired
	private BookDao bookDao;
	
	/**
	 * Convert a {@link com.library.repository.dto.BookDto BookDto} to {@link com.library.repository.dto.BookDto BookDto}.
	 * @param source the BookDto which need to be converted.
	 */
	@Override
	public BookEntity convert(BookDto source) {
		if (source == null) {
			return null;
		}
		
		BookEntity bookEntity = getEntityFromDtOrNew(source);
		
		bookEntity.setAuthor(source.getAuthor());
		bookEntity.setTitle(source.getTitle());
		bookEntity.setQuantity(source.getQuantity());
		bookEntity.setDescription(source.getDescription());
		bookEntity.setReleaseDate(source.getReleaseDate());
		
		return bookEntity;		
	}
	
	private BookEntity getEntityFromDtOrNew(BookDto source) {
		if (source.getId() == null) {
			return new BookEntity();
		}
		
		Optional<BookEntity> bookEntityOptional = bookDao.findById(source.getId());

		if (bookEntityOptional.isPresent()) {
			return bookEntityOptional.get();
		} else {
			return new BookEntity();
		}
	}

}
