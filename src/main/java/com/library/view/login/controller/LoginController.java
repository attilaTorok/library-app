package com.library.view.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.view.login.model.AddLoginRequest;

/**
 * A spring controller to handle the /login requests.
 * 
 * @author Török Attila
 */
@Controller
public class LoginController {

	public static final String REQUEST_MAPPING = "/login";
	
	/**
	 * Define model attribute for the controller.
	 * 
	 * @param addLoginRequest a request model
	 * @return an empty request
	 */
	@ModelAttribute("addLoginRequest")
	public AddLoginRequest createLoginModel(@ModelAttribute AddLoginRequest addLoginRequest) {
		return new AddLoginRequest();
	}
	
	/**
	 * Handler on /login get requests.
	 * 
	 * @return the login page
	 */
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }
	
}
