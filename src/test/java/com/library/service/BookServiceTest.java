package com.library.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import com.library.LibraryApplication;
import com.library.repository.converter.BookEntityToDto;
import com.library.repository.dto.BookDto;
import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;
import com.library.repository.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LibraryApplication.class)
@ActiveProfiles("test")
public class BookServiceTest {

	@Autowired
	BookService bookService;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	BookEntityToDto bookEntityToDto;
	
	private BookEntity entity;

	@After
	public void afterTest() {
		bookDao.deleteAll();
	}

	@Test
	public void getByIdTest() {
		BookDto dto = new BookDto();
		dto.setId(1L);
		bookService.save(dto);
		
		bookService.getById(1L);
		bookDao.findById(1L);
	}

	@Test
	public void getDataTest() {
		entity = new BookEntity();
		bookDao.save(entity);
		
		entity = new BookEntity();
		bookDao.save(entity);
		
		List<BookDto> results = bookService.getData();
		
		assertEquals(2, results.size());
	}
	
	@Test
	public void saveTest() {
		List<BookDto> results = bookService.getData();
		assertEquals(0, results.size());
		
		BookDto dto = new BookDto();		
		bookService.save(dto);
		
		results = bookService.getData();
		assertEquals(1, results.size());
	}
	
	@Test
	public void deleteTest() {
		entity = new BookEntity();
		bookDao.save(entity);
		
		List<BookDto> results = bookService.getData();
		assertEquals(1, results.size());
		
		bookService.delete(results.get(0));
		
		results = bookService.getData();
		assertEquals(0, results.size());
	}

	@Test
	public void findBooksByTitle() {
		BookDto be = new BookDto();
		be.setTitle("kacsa");
		bookService.save(be);
		
		List<BookDto> result = bookService.findBooksByTitle("Kacsa");
		
		assertEquals(1, result.size());
	}

}
