package com.library.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.library.data.AuthorDataLoader;
import com.library.data.BookDataLoader;
import com.library.data.ResourceLoader;
import com.library.domain.AuthorEntity;
import com.library.domain.BookEntity;

@Configuration
@PropertySource(value = { "classpath:load.properties "}, encoding = "UTF-8")
public class LoadConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadConfig.class);

    @Value("${author.file}")
    private String authorFile;

    @Value("${book.file}")
    private String bookFile;

    @Bean
    public ResourceLoader<AuthorEntity> authorDataLoader() {
        return new AuthorDataLoader(authorFile);
    }

    @Bean
    public ResourceLoader<BookEntity> bookDataLoader() {
        return new BookDataLoader(bookFile);
    }

}
