package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    /**
     * Create a new User
     *
     * @param user
     * @return User
     */
    User create(User user);

    /**
     * Read User by id
     *
     * @param id
     * @return User
     */
    User read(Long id);

    /**
     * Update user
     *
     * @param user
     */
    User update(User user);

    /**
     * Delete user
     *
     * @param user
     */
    void delete(User user);

    /**
     * close the entity manager factory
     */
    void close();
}
