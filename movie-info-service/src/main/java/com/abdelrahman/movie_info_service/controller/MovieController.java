package com.abdelrahman.movie_info_service.controller;

import com.abdelrahman.movie_info_service.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.abdelrahman.movie_info_service.controller.MovieController.MOVIE_INFO_PATH;

@RestController
@RequestMapping(MOVIE_INFO_PATH)
public class MovieController {
    protected static final String MOVIE_INFO_PATH = "/api/v1/movies";

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "title", "description");

    }
}
