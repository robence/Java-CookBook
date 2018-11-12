package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Recipe;
import com.elte.alkfejl.recept.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    ResponseEntity<Iterable<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Recipe> get(@PathVariable Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.isPresent()
            ? ResponseEntity.ok(recipe.get())
            : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeRepository.save(recipe));
    }

    @PutMapping("/update")
    public ResponseEntity<Recipe> update(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeRepository.save(recipe));
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable  Integer id) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (!oRecipe.isPresent()) {
            return false;
        }

        recipeRepository.delete(oRecipe.get());
        return true;
    }

}