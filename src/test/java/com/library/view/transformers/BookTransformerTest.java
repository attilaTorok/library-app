package com.library.view.transformers;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.LibraryApplication;
import com.library.repository.dto.BookDto;
import com.library.view.books.controller.DeleteBookController;
import com.library.view.books.controller.ShowBookController;
import com.library.view.books.model.BookDetailsView;
import com.library.view.books.model.BookSummaryView;
import com.library.view.books.transformer.BookTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
public class BookTransformerTest {

	@Autowired
	private BookTransformer transformer;
	
	private List<BookDto> books;
	
	@Before
	public void setUp() {
		books = new ArrayList<>();
		BookDto dto1 = new BookDto();
		
		dto1.setAuthor("author");
		dto1.setTitle("title");
		dto1.setQuantity(2);
		dto1.setDescription("desc");
		dto1.setId(1L);
		dto1.setReleaseDate(LocalDateTime.now());
		
		books.add(dto1);
		
		BookDto dto2 = new BookDto();
		dto2.setAuthor("author2");
		dto2.setTitle("title2");
		dto2.setQuantity(3);
		dto2.setDescription("desc2");
		dto2.setId(2L);
		dto2.setReleaseDate(LocalDateTime.now());
		books.add(dto2);
	}
	
	@Test
	public void transformBookToSummaryTest() {
		BookDto transform = books.get(0);
		String deleteUrl = String.format(BookTransformer.BOOK_QUERY_URL_PATTERN, DeleteBookController.REQUEST_MAPPING, transform.getId());
		String detailsUrl = String.format(BookTransformer.BOOK_QUERY_URL_PATTERN, ShowBookController.REQUEST_MAPPING, transform.getId());
		BookSummaryView transformed = transformer.transformBookToSummary(transform);
		
		assertEquals(transformed.getAuthor(), transform.getAuthor());
		assertEquals(transformed.getTitle(), transform.getTitle());
		assertEquals(transformed.getQuantity(), transform.getQuantity());
		assertEquals(transformed.getId(), transform.getId());
		assertEquals(transformed.getDeleteUrl(), deleteUrl);
		assertEquals(transformed.getDetailsUrl(), detailsUrl);
	}
	
	@Test
	public void transformBooksToSummariesTest() {
		List<BookSummaryView> summaries = transformer.transformBooksToSummaries(books);
		
		assertEquals(summaries.size(), books.size());
	}
	
	@Test
	public void transformBookToDetailsTest() {
		BookDetailsView transformed = transformer.transformBookToDetails(books.get(0));
		
		assertEquals(transformed.getDescription(), books.get(0).getDescription());
	}
	
}
