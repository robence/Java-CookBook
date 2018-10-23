package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Recipe;
import com.elte.alkfejl.recept.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/recipe")
@Slf4j
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/")
    ResponseEntity<Iterable<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Recipe> get(@PathVariable Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return ResponseEntity.ok(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}