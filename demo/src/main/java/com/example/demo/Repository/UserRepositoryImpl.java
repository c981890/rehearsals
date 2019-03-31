package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.demo.Entity");
    private EntityManager em;
    private FullTextEntityManager ftem;

    public UserRepositoryImpl() {

        this.em = emf.createEntityManager();
        this.ftem = Search.getFullTextEntityManager(em);
    }

    public List<User> search(String keyword) {
        // em.getTransaction().begin();
        // TODO your logic here with full-text entity manager ...
        QueryBuilder qb = this.ftem.getSearchFactory()
                .buildQueryBuilder().forEntity(User.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword()
                .onFields("location")
                .matching(keyword)
                .createQuery();

        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query persistenceQuery =
                this.ftem.createFullTextQuery(query, User.class);

        // execute search
        List<User> result = persistenceQuery.getResultList();

        // em.getTransaction().commit();
        // em.close();

        return result;
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
