package com.abdelrahman.ratings_data_service.controller;

import com.abdelrahman.ratings_data_service.model.MovieRating;
import com.abdelrahman.ratings_data_service.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.abdelrahman.ratings_data_service.controller.RatingsController.RATINGS_CONTROLLER_PATH;

@RestController
@RequestMapping(RATINGS_CONTROLLER_PATH)
public class RatingsController {
    protected final static String RATINGS_CONTROLLER_PATH = "api/v1/ratings";

    @GetMapping("/movie/{movieId}")
    public MovieRating getMovieRating(@PathVariable String movieId){
        return new MovieRating(movieId,10);
    }

    @GetMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        return new UserRating(userId, List.of(new MovieRating("123",7)));

    }
}
