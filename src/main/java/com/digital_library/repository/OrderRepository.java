package com.digital_library.repository;


import com.digital_library.domain.Order;
import com.digital_library.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OrderRepository {
    SessionFactory sessionFactory;

    public OrderRepository() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Order> getAllOrders() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Order");
        ArrayList<Order> list = (ArrayList<Order>) query.getResultList();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Order getOrderById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Order order = session.get(Order.class, id);

        session.getTransaction().commit();
        session.close();
        return order;
    }

    public void createOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    public void updateOrder(Order order){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteOrder(Order order){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }
}
