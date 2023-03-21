package com.digital_library.repository;

import com.digital_library.domain.Author;
import com.digital_library.domain.Order;
import com.digital_library.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByNameStartingWith(String letter);

    User findUserByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT role FROM roles WHERE user_id=:id")
    String getRole(int id);

    @Query(nativeQuery = true,value = "SELECT * FROM users WHERE id=?1S")
    User HerniaKakayto(int age);
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO roles(id,user_id,role) VALUES (DEFAULT,:userId,'USER')")
    void addUserRole(Integer userId);
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO roles(id,user_id,role) VALUES (DEFAULT,:userId,'ADMIN')")
    void addAdminRole(Integer userId);

}


/*{
    SessionFactory sessionFactory;

    public UserRepository() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User");
        ArrayList<User> list = (ArrayList<User>) query.getResultList();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, id);

        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
*/