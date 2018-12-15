package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Review;
import com.elte.alkfejl.recept.model.User;
import com.elte.alkfejl.recept.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/")
    ResponseEntity<Iterable<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Review> get(@PathVariable Integer id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.isPresent()
                ? ResponseEntity.ok(review.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Review> save(@RequestBody Review review) {
        return ResponseEntity.ok(reviewRepository.save(review));
    }

    @PutMapping("/update")
    public ResponseEntity<Review> update(@RequestBody Review review) {
        return ResponseEntity.ok(reviewRepository.save(review));
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        Optional<Review> oReview = reviewRepository.findById(id);
        if (!oReview.isPresent()) {
            return false;
        }

        reviewRepository.delete(oReview.get());
        return true;
    }
}
