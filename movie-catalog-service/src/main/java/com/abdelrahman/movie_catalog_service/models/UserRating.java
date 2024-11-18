package com.abdelrahman.movie_catalog_service.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@Validated
public class UserRating {
    @NotNull
    private String userId;
    @NotNull
    private List<MovieRating> ratings;

}
