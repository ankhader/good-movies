package com.abdelrahman.movie_catalog_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRating {
    private String movieId;
    private int rating;
}
