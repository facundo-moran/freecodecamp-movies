package com.morandev.moviesapi.controller;

import com.morandev.moviesapi.handlers.http.BadRequestException;
import com.morandev.moviesapi.model.review.Review;
import com.morandev.moviesapi.model.review.dto.ReviewDto;
import com.morandev.moviesapi.service.impl.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewDto reviewDto) {
        try {
            Review review = this.reviewService.createReview(reviewDto.getBody(), reviewDto.getImdb());
            return ResponseEntity.status(HttpStatus.CREATED).body(review);
        } catch (Exception ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Review>> getAllMovies() {
        Collection<Review> movies = this.reviewService.getAllReviews();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }
}
