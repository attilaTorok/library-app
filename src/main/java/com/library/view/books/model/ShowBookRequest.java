package com.library.view.books.model;

import lombok.Getter;
import lombok.Setter;

/**
 * A Model class that hold information about a requests which goes to /showBook.
 * 
 * @author Török Attila
 */
@Setter
@Getter
public class ShowBookRequest {

	private Long bookId;
	
}
