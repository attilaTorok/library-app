package com.library;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.view.books.controller.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
public class SmokeTest {

    @Autowired
    private BookController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}