package com.library.view.transformers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.LibraryApplication;
import com.library.repository.dto.BookDto;
import com.library.view.addbook.model.AddBookRequest;
import com.library.view.addbook.transformer.AddBookTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class AddBookTransformerTest {

	@Autowired
	private AddBookTransformer transformer;
	
	private AddBookRequest addBookRequest;
	
	@Before
	public void setUp() {
		addBookRequest = new AddBookRequest();
		
		addBookRequest.setAuthor("author");
		addBookRequest.setTitle("title");
		addBookRequest.setQuantity(2);
	}
	
	@Test
	public void testTranformRunsNormally() {
		BookDto dto = transformer.transformAddBookRequestToBookDto(addBookRequest);
		
		assertEquals(addBookRequest.getAuthor(), dto.getAuthor());
		assertEquals(addBookRequest.getTitle(), dto.getTitle());
		assertEquals(addBookRequest.getQuantity(), dto.getQuantity());
	}
	
	@Test
	public void testTranformIfParamNullReturnsNull() {
		addBookRequest = null;
		BookDto dto = transformer.transformAddBookRequestToBookDto(addBookRequest);
		
		assertEquals(null, dto);
	}
	
}
