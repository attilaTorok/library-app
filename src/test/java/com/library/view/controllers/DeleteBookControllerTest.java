package com.library.view.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.library.LibraryApplication;
import com.library.repository.dto.BookDto;
import com.library.repository.service.BookService;
import com.library.view.addbook.model.AddBookRequest;
import com.library.view.books.controller.DeleteBookController;
import com.library.view.books.model.ShowBookRequest;
import com.library.view.books.transformer.BookTransformer;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class DeleteBookControllerTest {

	@Autowired
	private DeleteBookController controller;
			
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }
	
	@Test
	public void test() throws Exception {
		ShowBookRequest bookrequest = new ShowBookRequest();
		bookrequest.setBookId(1L);
		
		BookDto book = new BookDto();
		book.setId(1L);
		BookService bookService = Mockito.mock(BookService.class);
		Mockito.when(bookService.getById(1L)).thenReturn(book);
		String url = String.format(BookTransformer.BOOK_QUERY_URL_PATTERN, DeleteBookController.REQUEST_MAPPING, book.getId());
		
		//mockMvc.perform(post(url)
		//		.param("id", String.valueOf(bookrequest.getBookId())));
	}
	
}
