package com.paradz3033.dao;

import com.paradz3033.HibernateUtil;
import com.paradz3033.model.Movie;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class MovieDaoImpl implements MovieDao{

    @Override
    public boolean addMovie(Movie movie) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<Movie> getMovies() {
        List <Movie> movies = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            movies = session.createQuery("from Movie", Movie.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
    }
        return movies;

}

    @Override
    public Movie getMovie(long id) {
        Movie movie = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List <Movie> movies = session.createQuery("from Movie m WHERE m.id = "+id, Movie.class).getResultList();
            movie= movies.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movie;
    }
}
