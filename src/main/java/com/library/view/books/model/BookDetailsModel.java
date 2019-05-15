package com.library.view.books.model;

import lombok.Getter;
import lombok.Setter;

/**
 * A Model class to hold informations about {@link com.library.view.books.model.BookSummaryView BookSummaryView} and
 * {@link com.library.view.books.model.BookDetailsView BookDetailsView}.
 * 
 * @author Török Attila
 */
@Getter
@Setter 
public class BookDetailsModel {

	private BookSummaryView bookSummary;
	private BookDetailsView bookDetails;
	
	public BookDetailsModel(BookSummaryView bookSummary, BookDetailsView bookDetails) {
		this.bookDetails = bookDetails;
		this.bookSummary = bookSummary;
	}
	
}
