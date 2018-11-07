package com.elte.alkfejl.recept.repository;

import com.elte.alkfejl.recept.model.Ingredients;
import com.elte.alkfejl.recept.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients, Integer> {

    Iterable<Ingredients> findAllByRecipe(Recipe recipe);
}
