package net.omrryldrm.library.controller;


import net.omrryldrm.library.model.Author;
import net.omrryldrm.library.model.Book;
import net.omrryldrm.library.model.Publisher;
import net.omrryldrm.library.service.AuthorService;
import net.omrryldrm.library.service.BookService;
import net.omrryldrm.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    // book list
    @GetMapping("/")
    public String viewBookList(Model model, String keyword) {

        if (keyword != null) {
            model.addAttribute("listBooks", bookService.findByKeyword(keyword));
        } else {

            List<Book> bookList = bookService.getBook();
            model.addAttribute("listBooks", bookList);
        }
        return "index";

    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        // create model attribute to bind form data
        Book book = new Book();
        List<Author> author = authorService.getAllAuthors();
        List<Publisher> publisher = publisherService.getPublisher();
        model.addAttribute("book", book);
        model.addAttribute("author", author);
        model.addAttribute("publisher", publisher);


        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {


        // save book to database
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForBookUpdate/{bookId}")
    public String showFormForBookUpdate(@PathVariable(value = "bookId") long bookId, Model model) {

        // get book from the service
        Book book = bookService.getBookById(bookId);

        List<Author> author = authorService.getAllAuthors();
        List<Publisher> publisher = publisherService.getPublisher();
        model.addAttribute("author", author);
        model.addAttribute("publisher", publisher);

        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") long bookId) {

        // call delete employee method
        this.bookService.deleteBookById(bookId);
        return "redirect:/";
    }

}
