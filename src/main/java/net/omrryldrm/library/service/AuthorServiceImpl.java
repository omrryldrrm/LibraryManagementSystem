package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Author;
import net.omrryldrm.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;// @Autowired anotasyonu sayesinde bir bean içerisindeki değerleri başka
	// beanin içerisine enjekte edebilir değerlerini koruyarak
	// kullanabiliriz. @Autowired anotasyonunu bir değişken, setter ya da
	// yapılandırıcı metot üzerinde kullanılabilmekteyiz.

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void saveAuthor(Author author) {
		this.authorRepository.save(author);

	}

	@Override
	public Author getAuthorById(long authorId) {
		return authorRepository.getOne(authorId);
	}

	@Override
	public void deleteAuthorById(long authorId) {
		this.authorRepository.deleteById(authorId);


	}

}
