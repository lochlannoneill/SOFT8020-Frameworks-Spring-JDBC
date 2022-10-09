package ie.lochlann.service;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    int count();
    List<Movie> findAll();
    Optional<Movie> findAMovie(int id);
    List<Movie> findMoviesByDirector(int id);
    boolean deleteMovie(int id);
    boolean addMovie(int movieId, String title, String releaseDate, double earnings, int director_id);  // TODO
    boolean changeMovieEarnings(int id, double newEarnings);
    boolean changeDirector(int movieId, int newDirectorId); // TODO

}
