package com.morandev.moviesapi.model.review.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    @NotNull
    @Size(min = 2, message = "review body should have at least 2 characters")
    private String body;
    @NotNull
    @Size(min = 9, message = "imdb should have at least 9 characters")
    private String imdb;
}
