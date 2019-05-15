package com.library.repository.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.converter.BookDtoToEntity;
import com.library.repository.converter.BookEntityToDto;
import com.library.repository.dto.BookDto;
import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;

/**
 * A spring service which get entities from the database and return them as dtos.
 * 
 * @author Török Attila
 *
 */
@Service
public class BookService implements IOService<BookDto> {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookEntityToDto entityToDtoConverter;

    @Autowired
    private BookDtoToEntity dtoToEntityConverter;
   
    @Override
    public List<BookDto> getData() {
        List<BookDto> books = new ArrayList<>();
        bookDao.findAll().forEach(entity -> {
            books.add(entityToDtoConverter.convert(entity));
        });
        
        return books;
    }

    @Override
    public BookDto getById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookDao.findById(id);

        if (bookEntityOptional.isPresent()) {
            return entityToDtoConverter.convert(bookEntityOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public void save(BookDto t) {
        bookDao.save(dtoToEntityConverter.convert(t));
    }

	@Override
	public void delete(BookDto t) {
		bookDao.delete(dtoToEntityConverter.convert(t));		
	}

	/**
	 * Perform a database query with the given book title.
	 * @param the title of the book
	 * @return books with the title
	 */
	public List<BookDto> findBooksByTitle(String title) {

		List<BookDto> books = new ArrayList<>();
		findBookEntities(formatQuery(title)).forEach(entity -> {
            books.add(entityToDtoConverter.convert(entity));
        });
        
        return books;
	}
	
	private String formatQuery(String title) {
        String result;
        if (title == null) {
            result = "%";
        } else {
            result = String.format("%%%s%%", title);
        }
        return result;
    }
	
	private Iterable<BookEntity> findBookEntities(String title) {
        return bookDao.findByTitleIgnoreCaseLike(title);
    }

}
