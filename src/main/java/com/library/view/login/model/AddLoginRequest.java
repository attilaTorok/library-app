package com.library.view.login.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * The model for the login page.
 * 
 * @author Török Attila
 */
@Getter
@Setter
public class AddLoginRequest {

	@NotNull
	@Size(min = 2, max = 255)
	private String username;
	
	@NotNull
	@Size(min = 2, max = 255)
	private String password;
}
