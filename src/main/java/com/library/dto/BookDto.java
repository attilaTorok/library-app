package com.library.dto;

import java.time.LocalDateTime;

public class BookDto {

	private Long id;
	private String title;
	private AuthorDto author;
	private LocalDateTime releaseDate;
	private boolean loaned;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public AuthorDto getAuthor() {
		return author;
	}
	
	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
	
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public boolean isLoaned() {
		return loaned;
	}
	
	public void setLoaned(boolean loaned) {
		this.loaned = loaned;
	}
	
}
