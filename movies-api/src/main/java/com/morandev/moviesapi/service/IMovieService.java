package com.morandev.moviesapi.service;

import com.morandev.moviesapi.model.movie.Movie;

import java.util.Collection;
import java.util.Optional;

public interface IMovieService {
    Collection<Movie> getAllMovies();
    Optional<Movie> findMovieByImdbId(String imdb);
}
