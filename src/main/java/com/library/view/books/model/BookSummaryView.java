package com.library.view.books.model;

import lombok.Getter;
import lombok.Setter;

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
