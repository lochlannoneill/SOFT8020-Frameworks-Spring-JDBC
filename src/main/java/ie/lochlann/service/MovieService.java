package ie.lochlann.service;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    int count();
    List<Movie> findAll();
//    List<Movie> findAllByDirectorId(int id);
    Optional<Movie> findAMovie(int id);
    boolean deleteMovie(int id);
    boolean addMovie(Movie newMovie);
    boolean changeMovieEarnings(int id, double earnings);

}
