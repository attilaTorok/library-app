package com.library.repository.repository.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * {@link com.library.repository.repository.domain.BookEntity BookEntity} is a class which defines the data in the database.
 * 
 * @author Török Attila
 *
 */
@Entity
@Setter
@Getter
@Table(name = "Book")
public class BookEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String author;

    private LocalDateTime releaseDate;
    
    @Column(length=1000)
    private String description;

    private int quantity;
	
}
