package com.library.view.addbook.transformer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.library.repository.dto.BookDto;
import com.library.view.addbook.model.AddBookRequest;

/**
 * {@link com.library.view.addbook.transformer.AddBookTransformer AddBookTransformer} is describing a Java class that can perform
 *  {@link com.library.view.addbook.model.AddBookRequest AddBookRequest}-to-{@link com.library.repository.dto.BookDto BookDto} conversions.
 * 
 * @author Török Attila
 */
@Component
public class AddBookTransformer {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
	
	/**
	 * Transform the given {@link com.library.view.addbook.model.AddBookRequest AddBookRequest} to {@link com.library.repository.dto.BookDto BookDto}.
	 * @param an {@link com.library.view.addbook.model.AddBookRequest AddBookRequest} object
	 * @return a new {@link com.library.repository.dto.BookDto BookDto} object from the parameter
	 */
	public BookDto transformAddBookRequestToBookDto(AddBookRequest addBookRequest) {
		if (addBookRequest == null) {
			return null;
		}
		
		BookDto bookDto = new BookDto();
		
		bookDto.setAuthor(addBookRequest.getAuthor());
		bookDto.setTitle(addBookRequest.getTitle());
		bookDto.setReleaseDate(LocalDateTime.now());
		bookDto.setQuantity(addBookRequest.getQuantity());
		
		return bookDto;
	}
	
}
