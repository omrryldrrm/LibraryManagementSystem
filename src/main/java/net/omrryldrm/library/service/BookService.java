package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Book;

import java.util.List;


public interface BookService {

	List<Book> getBook();

	void saveBook(Book book);

	Book getBookById(long id);

	void deleteBookById(long id);

	List<Book> findByKeyword(String keyword);
}
