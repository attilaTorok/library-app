package com.library.view.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.repository.dto.UserDto;
import com.library.repository.service.UserService;
import com.library.view.login.model.AddLoginRequest;

/**
 * A spring controller to handle the /loginPost requests.
 * 
 * @author Török Attila
 */
@Controller
public class LoginPostController {

	public static final String REQUEST_MAPPING = "/loginPost";
	
	@Autowired
	private UserService userService;


	/**
	 * Define model attribute for the controller.
	 * 
	 * @param addLoginRequest a requests model
	 * @return an empty request
	 */
	@ModelAttribute("addLoginRequest")
	public AddLoginRequest createLoginModel(@ModelAttribute AddLoginRequest addLoginRequest) {
		return new AddLoginRequest();
	}

	/**
	 * Handling the /loginPost requests.
	 * 
	 * @param addLoginRequest the model of the request.
	 * @param bindingResult {@link org.springframework.validation.BindingResult BindingResult}
	 * @param redirectAttributes {@link org.springframework.web.servlet.mvc.support.RedirectAttributes RedirectAttributes}
	 * @return a view depends on the outcome of the function body
	 * @throws IOException
	 */
	@RequestMapping(value = REQUEST_MAPPING)
	private String checkLogin(AddLoginRequest addLoginRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
		String result;
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			UserDto userDto;
			try {
				userDto = userService.getByUsername(addLoginRequest.getUsername());
			} catch (NullPointerException e) {
				return "login";
			}
			
			if (userDto.getPassword() == addLoginRequest.getPassword()) {
				result = "books";
			}
			result = "books";
		}

		return result;
		
	}
	
}
