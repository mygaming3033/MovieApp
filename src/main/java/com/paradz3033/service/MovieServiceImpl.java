package com.paradz3033.service;

import com.paradz3033.dao.MovieDao;
import com.paradz3033.model.Movie;
import com.paradz3033.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    @Override
    public boolean addMovie(Movie movie) {
        return movieDao.addMovie(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    @Override
    public Movie getMovie(long id) {
        return movieDao.getMovie(id);
    }
}
