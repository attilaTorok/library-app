package com.library.view.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.library.LibraryApplication;
import com.library.repository.dto.BookDto;
import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;
import com.library.repository.service.BookService;
import com.library.view.books.controller.ShowBookController;
import com.library.view.books.transformer.BookTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ContextConfiguration
@ActiveProfiles("test")
public class ShowBookControllerTest {
	
	@Autowired
	private ShowBookController controller;
		
	@Autowired
	private BookTransformer transformer;
	
	@Autowired
	private BookService service;
	
	private BookDto dto;
	
	private String url;
	
	private MockMvc mockMvc;
	
	private Logger logger = LoggerFactory.getLogger(ShowBookControllerTest.class);
	
	@Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");
        
        dto = new BookDto();
        dto.setId(Long.valueOf(1));
        dto.setReleaseDate(LocalDateTime.now());
        
        service.save(dto);
        
        assertEquals(service.getById(Long.valueOf(1)).getId(), dto.getId());
        logger.info("assertEquals was good");

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }
	
	@Test
	public void showBookPageTest() throws Exception {        
        url = transformer.transformBookToSummary(dto).getDetailsUrl();
        		
        mockMvc.perform(get(url)
        		.param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("book_details"));
	}
	
}
