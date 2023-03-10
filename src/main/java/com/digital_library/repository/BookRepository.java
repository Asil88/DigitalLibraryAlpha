package com.digital_library.repository;

import com.digital_library.domain.Book;
import com.digital_library.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookRepository {
    SessionFactory sessionFactory;

    public BookRepository() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Book");
        ArrayList<Book> list = (ArrayList<Book>) query.getResultList();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Book getBookById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, id);

        session.getTransaction().commit();
        session.close();
        return book;
    }

    public void createBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public void updateBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(book);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }
}