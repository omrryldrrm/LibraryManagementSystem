package net.omrryldrm.library.controller;

import net.omrryldrm.library.model.Author;
import net.omrryldrm.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;


	// author list
	@GetMapping("/viewAuthorList")
	public String viewAuthorList(Model model) {
		model.addAttribute("listAuthors", authorService.getAllAuthors());
		return "show_author";

	}

	@GetMapping("/showNewAuthorForm")
	public String showNewAuthorForm(Model model) {
		// create model attribute to bind form data
		Author author = new Author();
		model.addAttribute("author", author);
		return "new_author";
	}

	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author author) {
		// save publisher to database
		authorService.saveAuthor(author);
		return "redirect:/viewAuthorList";
	}

	@GetMapping("/showFormForAuthorUpdate/{authorId}")
	public String showFormForAuthorUpdate(@PathVariable(value = "authorId") long authorId, Model model) {

		// get author from the service
		Author author = authorService.getAuthorById(authorId);


		model.addAttribute("author", author);
		return "update_author";
	}

	@GetMapping("/deleteAuthor/{authorId}")
	public String deleteAuthor(@PathVariable(value = "authorId") long authorId) {

		// call delete author method
		this.authorService.deleteAuthorById(authorId);
		return "redirect:/viewAuthorList";
	}


}
