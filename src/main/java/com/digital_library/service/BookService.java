package com.digital_library.service;


import com.digital_library.domain.Book;
import com.digital_library.domain.Order;
import com.digital_library.repository.BookRepository;
import com.digital_library.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
   BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {this.bookRepository = bookRepository;}
    public ArrayList<Book> getAllBooks() {return bookRepository.getAllBooks();}
    public Book getBookById(int id) {return bookRepository.getBookById(id);}
    public void createBook(Book book) {bookRepository.createBook(book);}
    public void updateBookById(Book book) {
        bookRepository.updateBook(book);
    }
    public void deleteBook(Book book) {bookRepository.deleteBook(book);}
}
