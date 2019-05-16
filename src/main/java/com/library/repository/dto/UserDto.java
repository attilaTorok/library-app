package com.library.repository.dto;

import lombok.Setter;

import lombok.Getter;

/**
 * {@link com.library.repository.dto.UserDto UserDto} is describing a Java class that
 * represents a user in the service layer.
 * 
 * @author Török Attila
 *
 */
@Getter
@Setter
public class UserDto {

	private Long id;
	private String username;
	private String password;
	
}
