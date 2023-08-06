package com.morandev.moviesapi.model.review;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {
    @Id
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }
}
