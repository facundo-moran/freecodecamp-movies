package com.morandev.moviesapi.service.impl;

import com.morandev.moviesapi.model.movie.Movie;
import com.morandev.moviesapi.repository.IMovieRepository;
import com.morandev.moviesapi.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Collection<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return this.movieRepository.findMovieByImdb(imdbId);
    }
}
