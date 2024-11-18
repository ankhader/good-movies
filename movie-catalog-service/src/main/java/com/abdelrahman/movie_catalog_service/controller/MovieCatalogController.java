package com.abdelrahman.movie_catalog_service.controller;

import com.abdelrahman.movie_catalog_service.models.CatalogItem;
import com.abdelrahman.movie_catalog_service.models.Movie;
import com.abdelrahman.movie_catalog_service.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MovieCatalogController.ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING)
public class MovieCatalogController {
    public static final String ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING = "/api/v1/catalog";

    private final RestClient restClient;

    public MovieCatalogController(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }


    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restClient.get().uri("http://ratings-data-service/api/v1/ratings/user/" + userId).retrieve().body(UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restClient.get().uri("http://movie-info-service/api/v1/movies/" + rating.getMovieId()).retrieve().body(Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}
