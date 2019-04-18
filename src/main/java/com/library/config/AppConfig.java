package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.App;
import com.library.dto.AuthorDto;
import com.library.dto.BookDto;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.IOService;

@Configuration
@ComponentScan("com.library.converter")
@EnableJpaRepositories(basePackages = "com.library.repository")
@Import({ DataSourceConfig.class, JpaConfig.class, LoadConfig.class })
public class AppConfig {

    @Bean
    public App app() {
        return new App();
    }
    
    @Bean
    public IOService<AuthorDto> authorService() {
        return new AuthorService();
    }
    
    @Bean
    public IOService<BookDto> bookService() {
        return new BookService();
    }

}
