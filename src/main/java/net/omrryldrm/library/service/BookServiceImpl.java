package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Book;
import net.omrryldrm.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBook() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);

	}

	@Override
	public Book getBookById(long bookId) {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException(" Book not found for id : " + bookId);
		}
		return book;
	}

	@Override
	public void deleteBookById(long bookId) {
		this.bookRepository.deleteById(bookId);
	}

	//Get books by keywords
	public List<Book> findByKeyword(String keyword) {
		return this.bookRepository.findByKeyword(keyword);
	}


}
