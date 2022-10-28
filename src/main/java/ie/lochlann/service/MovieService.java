package ie.lochlann.service;

import ie.lochlann.entities.HighestEarnings;
import ie.lochlann.entities.Movie;
import ie.lochlann.entities.Result;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    int count();
//    List<Movie> findAll();
    List<Result> findAll();
    Optional<Movie> findAMovie(int id);
    List<Movie> findMoviesByDirector(int id);
    HighestEarnings findHighestEarningsAndDirectorName();
    Result findMovieTitleAndDirectorName(int movieId);
    double getAverageEarningsByDirectorId(int directorId);
    boolean deleteMovie(int id);
    boolean addMovie(Movie movie);
    boolean changeMovieEarnings(int id, double newEarnings);
    boolean changeDirector(int movieId, int newDirectorId);

}
