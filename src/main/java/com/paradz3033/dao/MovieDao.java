package com.paradz3033.dao;

import com.paradz3033.model.Movie;

import java.util.List;

public interface MovieDao {

    boolean addMovie(Movie movie);
    List<Movie> getMovies();
    Movie getMovie(long id);
}
