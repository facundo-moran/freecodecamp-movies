package com.morandev.moviesapi.model.movie;

import com.morandev.moviesapi.model.review.Review;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "movies")
public class Movie {
    @Id
    private ObjectId id;
    @Field("imdbId")
    private String imdb;
    private String title;
    private LocalDate releaseDate;
    private List<String> genres;
    private String poster;
    private List<String> backdrops;
    @DBRef
    private List<Review> reviewIds; //one to many one Movie many Reviews
}
