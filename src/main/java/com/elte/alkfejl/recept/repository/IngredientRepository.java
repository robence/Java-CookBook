package com.elte.alkfejl.recept.repository;

import com.elte.alkfejl.recept.model.Ingredient;
import com.elte.alkfejl.recept.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    Iterable<Ingredient> findAllByRecipe(Recipe recipe);
}
