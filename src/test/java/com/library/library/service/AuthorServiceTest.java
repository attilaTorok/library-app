package com.library.library.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.library.config.AppConfig;
import com.library.converter.AuthorDtoToEntity;
import com.library.converter.AuthorEntityToDto;
import com.library.domain.AuthorEntity;
import com.library.dto.AuthorDto;
import com.library.repository.AuthorRepository;
import com.library.service.AuthorService;
import com.library.service.IOService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = { AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorServiceTest {

    @Autowired
    IOService<AuthorDto> service;
    AuthorEntityToDto entityToDto;
    AuthorDtoToEntity dtoToEntity;
    
    @Mock
    AuthorRepository authorRepository;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        entityToDto = new AuthorEntityToDto();
        dtoToEntity = new AuthorDtoToEntity();
    }
    
    @Test
    public void testGetData() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(Long.valueOf(1));
        this.service.save(authorDto);
        
        //ArgumentCaptor<AuthorDto> argument = ArgumentCaptor.forClass(AuthorDto.class);
        ArgumentCaptor<AuthorDto> argument = ArgumentCaptor.forClass(AuthorDto.class);
        verify(authorRepository).save(dtoToEntity.convert(argument.capture()));
        assertEquals( authorDto.getId() , argument.capture().getId());
    }
    
}
