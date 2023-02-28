package com.digital_library.repository;

import com.digital_library.domain.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class AuthorRepository {
    SessionFactory sessionFactory;

    public AuthorRepository() {
        this.sessionFactory = new Configuration().configure().addAnnotatedClass(Author.class).buildSessionFactory();
    }

    public ArrayList <Author> getAllAuthors() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Author");
        ArrayList<Author> list = (ArrayList<Author>) query.getResultList();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Author getAuthorById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author author = session.get(Author.class, id);

        session.getTransaction().commit();
        session.close();
        return author;
    }

    public void createAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    public void updateAuthor(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(author);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAuthor(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }
}
