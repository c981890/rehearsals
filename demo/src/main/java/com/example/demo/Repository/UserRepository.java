package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    /**
     * Create a new Person
     *
     * @param person
     * @return Person
     */
    User create(User person);

    /**
     * Read Person by id
     *
     * @param id
     * @return Person
     */
    User read(Long id);

    /**
     * Update person
     *
     * @param person
     */
    User update(User person);

    /**
     * Delete person
     *
     * @param person
     */
    void delete(User person);

    /**
     * close the entity manager factory
     */
    void close();
}
