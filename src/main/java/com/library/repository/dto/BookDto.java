package com.library.repository.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * {@link com.library.repository.dto.BookDto BookDto} is describing a Java class that
 * represents a book in the service layer.
 * 
 * @author Török Attila
 *
 */
@Setter
@Getter
public class BookDto {

	private Long id;
    private String title;
    private String description;
    private String author;
    private LocalDateTime releaseDate;
    private int quantity;
	
}
