package net.omrryldrm.library.controller;

import net.omrryldrm.library.model.Publisher;
import net.omrryldrm.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	// publisher list
	@GetMapping("/viewPublisherList")
	public String viewPublisherList(Model model) {
		model.addAttribute("listPublisher", publisherService.getPublisher());
		return "show_publisher";

	}

	@GetMapping("/showNewPublisherForm")
	public String showNewPublisherForm(Model model) {
		// create model attribute to bind form data
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		return "new_publisher";
	}

	@PostMapping("/savePublisher")
	public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
		// save publisher to database
		publisherService.savePublisher(publisher);
		return "redirect:/viewPublisherList";
	}

	@GetMapping("/showFormForPublisherUpdate/{publisherId}")
	public String showFormForPublisherUpdate(@PathVariable(value = "publisherId") long publisherId, Model model) {

		// get publisher from the service
		Publisher publisher = publisherService.getPublisherById(publisherId);

		model.addAttribute("publisher", publisher);
		return "update_publisher";
	}

	@GetMapping("/deletePublisher/{publisherId}")
	public String deletePublisher(@PathVariable(value = "publisherId") long publisherId) {

		// call delete author method
		this.publisherService.deletePublisherById(publisherId);
		return "redirect:/viewPublisherList";
	}

}
