package com.library;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.library.config.AppConfig;
import com.library.data.AuthorDataLoader;
import com.library.data.BookDataLoader;
import com.library.data.ResourceLoader;
import com.library.domain.AuthorEntity;
import com.library.domain.BookEntity;
import com.library.dto.AuthorDto;
import com.library.dto.BookDto;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.service.AuthorService;
import com.library.service.IOService;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    @Autowired
    private IOService<AuthorDto> authorService;
    
    @Autowired
    private IOService<BookDto> bookService;
    
    public static void main( String[] args ) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);
            //app.insertToDb(appContext);
            app.play(appContext);
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

    private void play(ConfigurableApplicationContext appContext) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1) show authors\n2) show books");
        
        String input = sc.nextLine();
        if (input.equals("1")) {
            System.out.println("sup");
            for (AuthorDto adto : authorService.getData()) {
                System.out.println(adto.toString());
            }
        } else if (input.equals("2")) {
            for (BookDto adto : bookService.getData()) {
                System.out.println(adto.toString());
            }
        }
        
    }


}
