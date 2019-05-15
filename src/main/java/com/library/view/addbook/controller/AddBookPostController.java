package com.library.view.addbook.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.repository.service.BookService;
import com.library.view.addbook.model.AddBookRequest;
import com.library.view.addbook.transformer.AddBookTransformer;

/**
 * A spring controller to handle the /addBookPost post methods.
 * When a post comes in the controller save a new book in the database.
 * 
 * @author Török Attila
 */
@Controller
public class AddBookPostController {

	public static final String REQUEST_MAPPING = "/addBookPost";
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AddBookTransformer addBookTransformer;
	
	/**
	 * When a requests come to the /addBookPost page an {@link com.library.view.addbook.model.AddBookRequest AddBookRequest} passed to the controller.
	 * @param addBookRequest the model of the request.
	 * @return a new requests
	 */
	@ModelAttribute("addBookRequest")
	public AddBookRequest createListBooksModel(@ModelAttribute AddBookRequest addBookRequest) {
		return new AddBookRequest();
	}
	
	/**
	 * When a requests come to the /addBookPost page an {@link com.library.view.addbook.model.AddBookRequest AddBookRequest} passed to the controller.
	 * If it is a valid requests a new book is saved to the database.
	 * 
	 * @param addBookRequest the model of the request.
	 * @param bindingResult {@link org.springframework.validation.BindingResult BindingResult}
	 * @param redirectAttributes {@link org.springframework.web.servlet.mvc.support.RedirectAttributes RedirectAttributes}
	 * @return a view depends on the outcome of the function body
	 * @throws IOException
	 */
	@RequestMapping(value = REQUEST_MAPPING)	 
	private String createBook(@Valid AddBookRequest addBookRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
		String result;
		
		if (bindingResult.hasErrors()) {
			result = "add_book";
		} else {
			bookService.save(addBookTransformer.transformAddBookRequestToBookDto(addBookRequest));
			redirectAttributes.addFlashAttribute("message", String.format("Book '%s' of '%s' saved!", addBookRequest.getTitle(), addBookRequest.getAuthor()));
			result = "redirect:addBookForm";
		}
		
		return result;
	}
	
}
