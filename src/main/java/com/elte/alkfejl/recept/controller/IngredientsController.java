package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Ingredient;
import com.elte.alkfejl.recept.repository.IngredientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/")
    ResponseEntity<Iterable<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Ingredient> get(@PathVariable Integer id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            return ResponseEntity.ok(ingredient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientRepository.save(ingredient));
    }

    @PutMapping("/update")
    public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientRepository.save(ingredient));
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        Optional<Ingredient> oIngredient = ingredientRepository.findById(id);
        if (!oIngredient.isPresent()) {
            return false;
        }

        ingredientRepository.delete(oIngredient.get());
        return true;
    }
}
