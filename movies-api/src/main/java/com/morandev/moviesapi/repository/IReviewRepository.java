package com.morandev.moviesapi.repository;

import com.morandev.moviesapi.model.review.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends MongoRepository<Review, ObjectId> {}

