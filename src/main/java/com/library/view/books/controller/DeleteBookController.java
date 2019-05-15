package com.library.view.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.repository.dto.BookDto;
import com.library.repository.service.BookService;
import com.library.view.books.model.BookDetailsModel;
import com.library.view.books.model.BookDetailsView;
import com.library.view.books.model.BookSummaryView;
import com.library.view.books.model.ListBooksModel;
import com.library.view.books.model.ListBooksRequest;
import com.library.view.books.model.ShowBookRequest;
import com.library.view.books.transformer.BookTransformer;

public class DeleteBookController {

	public static final String REQUEST_MAPPING = "/deleteBook";
	
	@Autowired
	private BookService bookService;
	
	@ModelAttribute("bookDetailsModel")
    public void createBookDetailsModel(ShowBookRequest showBookRequest) {
		bookService.delete(bookService.getById(showBookRequest.getBookId()));
    }	
	
	@RequestMapping(value = "/valami")
    public String showBooks() {
		
        return "books";
    }
	
	
}
