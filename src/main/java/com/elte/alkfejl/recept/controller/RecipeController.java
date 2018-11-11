package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Recipe;
import com.elte.alkfejl.recept.model.User;
import com.elte.alkfejl.recept.repository.RecipeRepository;
import com.elte.alkfejl.recept.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/user")
    public ResponseEntity<Iterable<Recipe>> getRecipesByUser(@RequestParam String username) {
        Optional<User> oUser = userRepository.findByUsername(username);

        if (!oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(recipeRepository.findAllByUser(oUser.get()));
    }

}