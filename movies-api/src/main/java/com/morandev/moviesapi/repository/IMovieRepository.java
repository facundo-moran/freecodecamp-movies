package com.morandev.moviesapi.repository;

import com.morandev.moviesapi.model.movie.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdb(String imdb);
}
