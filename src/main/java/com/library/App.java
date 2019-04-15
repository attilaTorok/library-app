package com.library;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.library.config.AppConfig;
import com.library.data.AuthorDataLoader;
import com.library.data.BookDataLoader;
import com.library.data.DataLoader;
import com.library.data.ResourceLoader;
import com.library.domain.AuthorEntity;
import com.library.domain.BookEntity;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;

/**
 * Hello world!
 *
 */
public class App {

	public static void main( String[] args ) {
		try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
			App app = appContext.getBean(App.class);
			app.insertToDb(appContext);
			app.play();
		}
	}

	private void insertToDb(ConfigurableApplicationContext appContext) {
		AuthorRepository authorRepository = appContext.getBean(AuthorRepository.class);
		BookRepository bookRepository = appContext.getBean(BookRepository.class);
		
		ResourceLoader<AuthorEntity> authorEntityLoader = appContext.getBean(AuthorDataLoader.class);
		ResourceLoader<BookEntity> bookEntityLoader = appContext.getBean(BookDataLoader.class);
		
		for (AuthorEntity ae : authorEntityLoader.loadData()) {
			authorRepository.save(ae);
		}
		
		for (BookEntity be : bookEntityLoader.loadData()) {
			bookRepository.save(be);
		}
	}

	private void play() {
		
	}


}
