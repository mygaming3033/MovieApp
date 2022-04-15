package com.paradz3033.service;

import com.paradz3033.model.Movie;

import java.util.List;

public interface MovieService {

    boolean addMovie(Movie movie);
    List<Movie> getMovies();
    Movie getMovie(long id);
}
