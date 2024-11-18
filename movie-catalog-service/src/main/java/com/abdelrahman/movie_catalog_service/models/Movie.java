package com.abdelrahman.movie_catalog_service.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class Movie {
    @NotNull
    private String movieId;
    @NotNull
    private String name;
    private String description;
}
