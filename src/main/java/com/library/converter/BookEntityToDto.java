package com.library.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.library.domain.BookEntity;
import com.library.dto.BookDto;

@Component
public class BookEntityToDto implements Converter<BookEntity, BookDto> {

    @Autowired
    private AuthorEntityToDto authorEntityToDto;

    @Override
    public BookDto convert(BookEntity source) {
        if (source == null) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId(source.getId());
        bookDto.setTitle(source.getTitle());
        bookDto.setLoaned(source.isLoaned());
        bookDto.setReleaseDate(source.getReleaseDate());

        bookDto.setAuthor(authorEntityToDto.convert(source.getAuthor()));

        return bookDto;
    }

}
