package com.morandev.moviesapi.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.morandev.moviesapi.model.movie.Movie;
import com.morandev.moviesapi.model.review.Review;
import com.morandev.moviesapi.repository.IReviewRepository;
import com.morandev.moviesapi.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(IReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Review createReview(String body, String imdb) throws RuntimeException {
        /**
         *  1. save - CREAR REVIEW
         *  Si no se guarda (save) luego hay error de id nulo en el intento de update
         */
        final Review reviewCreated = this.reviewRepository.save(new Review(body));

        /**
         *  2. update - ACTUALIZAR MOVIE
         */
        final UpdateResult result = this.mongoTemplate.update(Movie.class)
                        .matching(Criteria.where("imdb").is(imdb))
                        .apply(new Update().push("reviewIds", reviewCreated)).first();

        if (result.getMatchedCount() != 1)
            throw new IllegalArgumentException("imdb: " + imdb + " is not valid");

        /**
         *  wasAcknowledged ->  if the write was acknowledged (ESCRITURA)
         */
        if (result.getModifiedCount() == 0 || !result.wasAcknowledged())
            throw new RuntimeException("Intento crear review de imdb: " + imdb + " sin éxito.");

        return reviewCreated;
    }

    @Override
    public Collection<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }
}
