package com.library.view.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.library.LibraryApplication;
import com.library.view.addbook.controller.AddBookFormController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class AddBookFormControllerTest {

	@Autowired
	private AddBookFormController controller;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }
	
	@Test
	public void getLoginPageTest() throws Exception {
        mockMvc.perform(get("/addBookForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_book"));
	}
	
}
