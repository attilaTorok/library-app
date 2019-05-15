package com.library.view.books.model;

import lombok.Getter;
import lombok.Setter;

/**
 * A Model class to hold informations about a book.
 * 
 * @author Török Attila
 */
@Setter
@Getter
public class BookSummaryView {

	private Long id;
	private String author;
	private String title;
	private String releaseDate;
	private int quantity;
	private String detailsUrl;
	private String deleteUrl;
	
}
