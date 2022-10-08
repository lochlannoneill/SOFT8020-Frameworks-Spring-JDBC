package ie.lochlann.service;

import ie.lochlann.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    int count();
    List<Movie> findAll();
    Optional<Movie> findAMovie(int id);
}
