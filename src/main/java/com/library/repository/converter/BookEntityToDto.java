package com.library.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.repository.dto.BookDto;
import com.library.repository.repository.domain.BookEntity;

/**
 * {@link com.library.repository.converter.BookDtoToEntity BookDtoToEntity} is describing a Java class that can perform
 *  {@link com.library.repository.repository.domain.BookEntity BookEntity}-to-{@link com.library.repository.dto.BookDto BookDto} conversions.
 * 
 * 
 * @author Török Attila
 *
 */
@Component
public class BookEntityToDto implements Converter<BookEntity, BookDto> {

	/**
	 * Convert a {@link com.library.repository.repository.domain.BookEntity BookEntity} to {@link com.library.repository.dto.BookDto BookDto}.
	 * @param source the BookDto which need to be converted.
	 */
    @Override
    public BookDto convert(BookEntity source) {
        if (source == null) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId(source.getId());
        bookDto.setTitle(source.getTitle());
        bookDto.setQuantity(source.getQuantity());
        bookDto.setReleaseDate(source.getReleaseDate());
        bookDto.setDescription(source.getDescription());

        bookDto.setAuthor(source.getAuthor());

        return bookDto;
    }

}
