package com.library.view.books.model;

import java.util.List;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
public class ListBooksModel {

	private List<BookSummaryView> books;

	public ListBooksModel(List<BookSummaryView> books) {
		super();
		this.books = books;
	}
	
}
