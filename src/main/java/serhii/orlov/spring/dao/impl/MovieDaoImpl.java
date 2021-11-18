package serhii.orlov.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import serhii.orlov.spring.dao.AbstractDao;
import serhii.orlov.spring.dao.MovieDao;
import serhii.orlov.spring.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
