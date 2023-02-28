package com.digital_library.controller;

import com.digital_library.domain.Article;
import com.digital_library.domain.Author;
import com.digital_library.service.ArticleService;
import com.digital_library.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        return new ResponseEntity<>(author, author.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createAuthor(@RequestBody @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        authorService.createAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateAuthorById(@RequestBody Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        authorService.updateAuthorById(author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestBody @Valid Author author) {
        authorService.deleteAuthor(author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
