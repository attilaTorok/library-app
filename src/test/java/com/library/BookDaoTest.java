package com.library;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class BookDaoTest {

	@Autowired
	BookDao bookDao;
	
	@After
	public void tearDown() {
		bookDao.deleteAll();
	}
	
	@Test
	public void findByTitleIgnoreCaseLikeTest() throws Exception {
		
		BookEntity be = new BookEntity();
		be.setTitle("kacsa");
		bookDao.save(be);
		
		BookEntity be2 = new BookEntity();
		be2.setTitle("kAcsA");
		bookDao.save(be2);
		
		List<BookEntity> result = bookDao.findByTitleIgnoreCaseLike("Kacsa");
		
		assertEquals(2, result.size());
		
	}
	
}
