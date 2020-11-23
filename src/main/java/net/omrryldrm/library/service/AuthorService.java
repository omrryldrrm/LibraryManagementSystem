package net.omrryldrm.library.service;

import net.omrryldrm.library.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    void saveAuthor(Author author);

    Author getAuthorById(long id);

    void deleteAuthorById(long id);
}
