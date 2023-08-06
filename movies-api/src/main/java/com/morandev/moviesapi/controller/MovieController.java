package com.morandev.moviesapi.controller;

import com.morandev.moviesapi.model.movie.Movie;
import com.morandev.moviesapi.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Collection<Movie>> getAllMovies() {
        Collection<Movie> movies = this.movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{imdb}")
    public ResponseEntity<Movie> getMovieByImdb(@PathVariable String imdb) {
        Optional<Movie> optMovie = this.movieService.findMovieByImdbId(imdb);

        return optMovie.map(movie -> ResponseEntity.status(HttpStatus.OK).body(movie)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
