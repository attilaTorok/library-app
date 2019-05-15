package com.library.view.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.repository.dto.BookDto;
import com.library.repository.service.BookService;
import com.library.view.books.model.BookSummaryView;
import com.library.view.books.model.ListBooksModel;
import com.library.view.books.model.ListBooksRequest;
import com.library.view.books.transformer.BookTransformer;

@Controller
public class BookController {
	
	public static final String REQUEST_MAPPING = "/books";

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookTransformer bookTransformer;
	
	@ModelAttribute("listBooksModel")
    public ListBooksModel createListBooksModel(ListBooksRequest listBooksRequest) {
        List<BookDto> books = listBooks(listBooksRequest);
        List<BookSummaryView> bookViews = transformBooks(books);
        return initListBooksModel(bookViews);
    }
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String showBooks() {
        return "books";
    }
	
	@PostMapping("/deleteBook")
	public String deleteBuyer(Long id) {
		bookService.delete(bookService.getById(id));
	    return "redirect:/books";
	}
	
	private List<BookSummaryView> transformBooks(List<BookDto> books) {
        return bookTransformer.transformBooksToSummaries(books);
    }

    private ListBooksModel initListBooksModel(List<BookSummaryView> bookViews) {
        return new ListBooksModel(bookViews);
    }

    private List<BookDto> listBooks(ListBooksRequest searchBooksRequest) {
        return bookService.findBooksByTitle(searchBooksRequest.getTitle());
    }
	
}
