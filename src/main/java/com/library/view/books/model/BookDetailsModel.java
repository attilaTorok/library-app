package com.library.view.books.model;

import lombok.Getter;
import lombok.Setter;

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
