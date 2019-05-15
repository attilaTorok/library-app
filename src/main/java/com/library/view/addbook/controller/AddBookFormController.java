package com.library.view.addbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.view.addbook.model.AddBookRequest;

/**
 * A spring controller to handle the /addBookForm get methods.
 * 
 * @author Török Attila
 */
@Controller
public class AddBookFormController {

	public static final String REQUEST_MAPPING = "/addBookForm";

	@ModelAttribute("addBookRequest")
	public AddBookRequest createListBooksModel(@ModelAttribute AddBookRequest addBookRequest) {
		return new AddBookRequest();
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	private String createBook() {
		return "add_book";
	}
	
}
