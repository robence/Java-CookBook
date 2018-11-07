package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Ingredients;
import com.elte.alkfejl.recept.repository.IngredientsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @GetMapping("/")
    ResponseEntity<Iterable<Ingredients>> getAllIngredients() {
        return ResponseEntity.ok(ingredientsRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Ingredients> get(@PathVariable Integer id) {
        Optional<Ingredients> ingredient = ingredientsRepository.findById(id);
        if (ingredient.isPresent()) {
            return ResponseEntity.ok(ingredient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
