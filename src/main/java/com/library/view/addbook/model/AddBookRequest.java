package com.library.view.addbook.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * A Java class to holds the data coming from the page.
 * 
 * @author Török Attila
 */
@Getter
@Setter
public class AddBookRequest {

	@NotNull
	@Size(min = 2, max = 255)
	private String title;
	@NotNull
	@Size(min = 2, max = 255)
	private String author;
	
	private int quantity;
	
}
