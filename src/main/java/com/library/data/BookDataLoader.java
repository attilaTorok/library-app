package com.library.data;

import java.util.List;

import com.library.domain.BookEntity;

public class BookDataLoader implements ResourceLoader<BookEntity> {

	private String resource;
	
	public BookDataLoader(String resource) {
		this.resource = resource;
	}
	
	@Override
	public List<BookEntity> loadData() {
		return null;
	}

}
