package com.elte.alkfejl.recept.repository;

import com.elte.alkfejl.recept.model.Recipe;
import com.elte.alkfejl.recept.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    Iterable<Recipe> findAllByUser(User user);
}