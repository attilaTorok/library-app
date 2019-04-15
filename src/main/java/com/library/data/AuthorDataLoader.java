package com.library.data;

import java.util.List;

import com.library.domain.AuthorEntity;

public class AuthorDataLoader implements ResourceLoader<AuthorEntity> {

	private final String resource;
	
	public AuthorDataLoader(String resource) {
		this.resource = resource;
	}
	
	@Override
	public List<AuthorEntity> loadData() {
		return null;	
	}

}
