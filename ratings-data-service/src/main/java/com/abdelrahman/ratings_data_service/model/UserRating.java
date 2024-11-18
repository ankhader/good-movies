package com.abdelrahman.ratings_data_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserRating {
    private String userId;
    private List<MovieRating> ratings;

}
