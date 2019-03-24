package com.example.demo.Repository;

import com.example.demo.Entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.demo.Entity");
    private EntityManager em;

    public UserRepositoryImpl() {
        em = emf.createEntityManager();
    }


    @Override
    public User create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User read(Long id) {
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User user) {
        em.getTransaction().begin();
        user = em.merge(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }
}
