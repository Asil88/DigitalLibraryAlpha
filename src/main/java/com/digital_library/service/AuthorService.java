package com.digital_library.service;

import com.digital_library.domain.Article;
import com.digital_library.domain.Author;
import com.digital_library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {

    public AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public ArrayList<Author> getAllAuthors() {return authorRepository.getAllAuthors();}
    public Author getAuthorById(int id) {
        return authorRepository.getAuthorById(id);
    }

    public void createAuthor(Author author) {
        authorRepository.createAuthor(author);
    }

    public void updateAuthorById(Author author) {
        authorRepository.updateAuthor(author);
    }

    public void deleteAuthor(Author author) {
        authorRepository.deleteAuthor(author);
    }
}
