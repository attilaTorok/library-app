package com.library.view.books.transformer;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.library.repository.dto.BookDto;
import com.library.view.books.controller.DeleteBookController;
import com.library.view.books.controller.ShowBookController;
import com.library.view.books.model.BookDetailsView;
import com.library.view.books.model.BookSummaryView;

@Component
public class BookTransformer {
	
	public static final String BOOK_QUERY_URL_PATTERN = "%s?bookId=%d";
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

	public List<BookSummaryView> transformBooksToSummaries(List<BookDto> books) {
        List<BookSummaryView> result = new ArrayList<BookSummaryView>();
        
        for (BookDto book : books) {
            result.add(transformBookToSummary(book));
        }
        
        return result;
    }

    public BookSummaryView transformBookToSummary(BookDto book) {
        BookSummaryView result = new BookSummaryView();
        
        result.setId(book.getId());
        result.setAuthor(book.getAuthor());
        result.setTitle(book.getTitle());
        result.setReleaseDate(book.getReleaseDate().format(formatter));
        result.setDetailsUrl(String.format(BOOK_QUERY_URL_PATTERN, ShowBookController.REQUEST_MAPPING, book.getId()));
        result.setDeleteUrl(String.format(BOOK_QUERY_URL_PATTERN, DeleteBookController.REQUEST_MAPPING, book.getId()));
        result.setQuantity(book.getQuantity());
        
        return result;
    }
    
    public BookDetailsView transformBookToDetails(BookDto book) {
    	BookDetailsView result = new BookDetailsView();
    	
    	result.setDescription(book.getDescription());
    	
    	return result;
    }
	
}
