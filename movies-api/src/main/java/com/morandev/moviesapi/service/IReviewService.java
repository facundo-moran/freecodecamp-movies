package com.morandev.moviesapi.service;

import com.morandev.moviesapi.model.review.Review;

import java.util.Collection;

public interface IReviewService {
    Review createReview(String body, String imdb);
    Collection<Review> getAllReviews();
}
