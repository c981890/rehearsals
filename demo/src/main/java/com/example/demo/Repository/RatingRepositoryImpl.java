package com.example.demo.Repository;

import com.example.demo.Entity.Rating;
import org.hibernate.query.Query;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RatingRepositoryImpl implements RatingRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.demo.Entity");
    private EntityManager em;
    private CriteriaBuilder cb;

    public RatingRepositoryImpl() {

        this.em = emf.createEntityManager();
        this.cb  = em.getCriteriaBuilder();
    }

    public List topItems() {
        CriteriaQuery<Rating> criteriaQuery =
                this.em.getCriteriaBuilder().createQuery(Rating.class);
        Root<Rating> rating = criteriaQuery.from(Rating.class);
        criteriaQuery.select(rating);
        Query limitedCriteriaQuery = (Query) this.em.createQuery(criteriaQuery)
                .setMaxResults(10); // this is the important part
        return limitedCriteriaQuery.getResultList();


/*
        CriteriaQuery<Double> cr = this.cb.createQuery(Double.class);
        Root<Rating> root = cr.from(Rating.class);
        cr.select(cb.avg(root.get("bookRating")));
        TypedQuery<Double> query = this.em.createQuery(cr);
        List top = query.setMaxResults(number).getResultList();
        return top;
        // Session session = cb.getSessionFactory().openSession();
        CriteriaQuery<Double> cq = this.cb.createQuery(Double.class);
        Root<Rating> root = cq.from(Rating.class);
        cq.select(this.cb.avg(root.get("bookRating")));
        TypedQuery<Double> query = this.em.createQuery(cq);
        double avgRating = query.getSingleResult();
        return avgRating;
*/
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
