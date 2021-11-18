package serhii.orlov.spring.service;

import java.util.List;
import serhii.orlov.spring.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
