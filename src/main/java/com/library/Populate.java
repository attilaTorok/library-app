package com.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.domain.BookEntity;

@Component
public class Populate {

	
	@Autowired
	private BookDao bookDao;
	
	public void initData() {		
		BookEntity bookEntity1 = createBookEntity("desc", "Anyam tyukja", LocalDateTime.now(), 2, "Sandor Petofi");		
		BookEntity bookEntity2 = createBookEntity("desce", "Ket kiskacsa", LocalDateTime.now(), 4, "Sandor Petofi");
		BookEntity bookEntity3 = createBookEntity("desce", "nokedli KACSA", LocalDateTime.now(), 4, "Endre Ady");
		BookEntity bookEntity4 = createBookEntity("desce", "Dicsak egy KaCSa", LocalDateTime.now(), 4, "Andy Vajna");
				
		bookDao.save(bookEntity1);
		bookDao.save(bookEntity2);
		bookDao.save(bookEntity3);
		bookDao.save(bookEntity4);
	}
		
	private BookEntity createBookEntity(String description, String title, LocalDateTime releaseDate, int quantity, String author) {
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setDescription(description);
		bookEntity.setQuantity(quantity);
		bookEntity.setReleaseDate(releaseDate);
		bookEntity.setTitle(title);
		bookEntity.setAuthor(author);
		
		return bookEntity;
	}
	
}
