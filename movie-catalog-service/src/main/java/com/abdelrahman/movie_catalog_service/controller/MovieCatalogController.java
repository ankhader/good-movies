package com.abdelrahman.movie_catalog_service.controller;

import com.abdelrahman.movie_catalog_service.models.CatalogItem;
import com.abdelrahman.movie_catalog_service.models.Movie;
import com.abdelrahman.movie_catalog_service.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MovieCatalogController.ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING)
public class MovieCatalogController {
    public static final String ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING = "/api/v1/catalog";

    private final RestTemplate restTemplate;

    public MovieCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/api/v1/ratings/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/api/v1/movies/" + rating.getMovieId(),Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}
