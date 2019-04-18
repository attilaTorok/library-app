package com.library.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.library.domain.BookEntity;

public class BookDataLoader implements ResourceLoader<BookEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDataLoader.class);
    
    private String resource;

    public BookDataLoader(String resource) {
        this.resource = resource;
    }

    @Override
    public List<BookEntity> loadData() {
        List<BookEntity> authors = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            InputStream input = getClass().getResourceAsStream(resource);
            authors = objectMapper.readValue(input, new TypeReference<List<BookEntity>>() {});
        } catch (JsonParseException e) {
            LOGGER.error("" + AuthorDataLoader.class.getSimpleName() + " cannot parse " + resource);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return authors;
    }

}
