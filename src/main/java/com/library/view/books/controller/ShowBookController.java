package com.library.view.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.repository.dto.BookDto;
import com.library.repository.service.BookService;
import com.library.view.books.model.BookDetailsModel;
import com.library.view.books.model.BookDetailsView;
import com.library.view.books.model.BookSummaryView;
import com.library.view.books.model.ShowBookRequest;
import com.library.view.books.transformer.BookTransformer;

/**
 * A spring controller to handle the /showBook requests.
 * 
 * @author Török Attila
 */
@Controller
public class ShowBookController {

	public static final String REQUEST_MAPPING = "/showBook";
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookTransformer bookTransformer;
	
	/**
	 * When a requests come to the /showBook page an {@link com.library.view.books.model.ShowBookRequest ShowBookRequest} passed to the controller.
	 * 
	 * @param showBookRequest the model of the request
	 * @return a list from the books in the database
	 */
	@ModelAttribute("bookDetailsModel")
    public BookDetailsModel createBookDetailsModel(ShowBookRequest showBookRequest) {
        BookDto book = findBook(showBookRequest.getBookId());
        return initBookDetailsModel(book);
    }
	
	/**
	 * Controller method to handle incoming methods.
	 * 
	 * @return the book_details view
	 */
	@RequestMapping(REQUEST_MAPPING)
    public String showBooks() {
        return "book_details";
    }

    private BookDetailsModel initBookDetailsModel(BookDto book) {
        BookSummaryView summary = bookTransformer.transformBookToSummary(book);
        BookDetailsView details = bookTransformer.transformBookToDetails(book);
        return new BookDetailsModel(summary, details);
    }

    private BookDto findBook(Long bookId) {
        return bookService.getById(bookId);
    }
	
}
