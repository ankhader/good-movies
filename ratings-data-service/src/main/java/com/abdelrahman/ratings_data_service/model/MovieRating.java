package com.abdelrahman.ratings_data_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRating {
    private String movieId;
    private int rating;
}
