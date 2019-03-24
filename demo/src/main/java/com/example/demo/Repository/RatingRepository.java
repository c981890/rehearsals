package com.example.demo.Repository;

import com.example.demo.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository {
    /**
     * Create a new Rating
     *
     * @param rating
     * @return Rating
     */
    Rating create(Rating rating);

    /**
     * Read Rating by id
     *
     * @param id
     * @return Rating
     */
    Rating read(Long id);

    /**
     * Update rating
     *
     * @param rating
     */
    Rating update(Rating rating);

    /**
     * Delete rating
     *
     * @param rating
     */
    void delete(Rating rating);

    /**
     * close the entity manager factory
     */
    void close();
}
