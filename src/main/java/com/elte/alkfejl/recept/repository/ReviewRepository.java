package com.elte.alkfejl.recept.repository;

import com.elte.alkfejl.recept.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
