package com.library.view.books.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.repository.service.BookService;
import com.library.view.books.model.ShowBookRequest;

/**
 * A spring controller to handle the /deleteBook requests.
 * 
 * @author Török Attila
 */
@Controller
public class DeleteBookController {

	public static final String REQUEST_MAPPING = "/deleteBook";
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Define model attribute for the controller.
	 * 
	 * @param showBookRequest the id of the book
	 * @return an empty request
	 */
	@ModelAttribute("bookDetailsModel")
    public ShowBookRequest createBookDetailsModel(ShowBookRequest showBookRequest) {
		return new ShowBookRequest();
    }	
	
	/**
	 * Deleting a book with the given id.
	 * 
	 * @param showBookRequest the id of the book
	 * @return redirecting to books page
	 */
	@RequestMapping(REQUEST_MAPPING)
    public String showBooks(ShowBookRequest showBookRequest) {
		bookService.delete(bookService.getById(showBookRequest.getBookId()));
        return "redirect:books";
    }
	
	
}
