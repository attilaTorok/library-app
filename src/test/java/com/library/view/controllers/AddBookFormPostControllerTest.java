package com.library.view.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.library.LibraryApplication;
import com.library.view.addbook.controller.AddBookFormController;
import com.library.view.addbook.model.AddBookRequest;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class AddBookFormPostControllerTest {
	
	@Autowired
	private AddBookFormController controller;
	
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
		AddBookRequest bookrequest = new AddBookRequest();
		bookrequest.setTitle("title");
		bookrequest.setAuthor("author");
		bookrequest.setQuantity(3);
		
		mockMvc.perform(post("/addBookPost")
				.param("author", bookrequest.getAuthor())
		        .param("title", bookrequest.getTitle())
		        .param("quantity", String.valueOf(bookrequest.getQuantity())));
	}
}
