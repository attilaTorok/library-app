package com.library.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.library.domain.AuthorEntity;

public class AuthorDataLoader implements ResourceLoader<AuthorEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorDataLoader.class);
    
    private final String resource;

    public AuthorDataLoader(String resource) {
        this.resource = resource;
    }

    @Override
    public List<AuthorEntity> loadData() {
        List<AuthorEntity> authors = new ArrayList<>();
        try {
            System.out.println("imma called");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            InputStream input = getClass().getResourceAsStream(resource);
            authors = objectMapper.readValue(input, new TypeReference<List<AuthorEntity>>() {});
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
