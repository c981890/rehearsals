package com.example.demo.Repository;

import com.example.demo.Entity.Rating;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RatingRepositoryImpl implements RatingRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.demo.Entity");
    private EntityManager em;

    public RatingRepositoryImpl() {
        em = emf.createEntityManager();
    }


    @Override
    public Rating create(Rating rating) {
        em.getTransaction().begin();
        em.persist(rating);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public Rating read(Long id) {
        em.getTransaction().begin();
        Rating rating = em.find(Rating.class, id);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public Rating update(Rating rating) {
        em.getTransaction().begin();
        rating = em.merge(rating);
        em.getTransaction().commit();
        return rating;
    }

    @Override
    public void delete(Rating rating) {
        em.getTransaction().begin();
        em.remove(rating);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

}
