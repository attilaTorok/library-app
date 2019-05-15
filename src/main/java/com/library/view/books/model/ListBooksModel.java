package com.library.view.books.model;

import java.util.List;

import lombok.Getter;

import lombok.Setter;

/**
 * A Model class to hold informations about {@link com.library.view.books.model.BookSummaryView BookSummaryView} and
 * {@link com.library.view.books.model.BookDetailsView BookDetailsView}.
 * 
 * @author Török Attila
 */
@Setter
@Getter
public class ListBooksModel {

	private List<BookSummaryView> books;

	public ListBooksModel(List<BookSummaryView> books) {
		this.books = books;
	}
	
}
