package ie.lochlann.repo;

import ie.lochlann.entities.HighestEarnings;
import ie.lochlann.entities.Movie;
import ie.lochlann.entities.Result;

import java.util.List;

public interface MovieRepo {
    int count();
    List<Result> findAll();
//    List<Movie> findAll();
    Movie findById(int id);
    List<Movie> findMoviesByDirector(int id);
    HighestEarnings findHighestEarningsAndDirectorName();
    Result findMovieTitleAndDirectorName(int movieId);
    boolean exists(int id);
    boolean existsByName(String title);
    int deleteMovie(int id);
    int addMovie(Movie movie);
    double getAverageEarningsByDirectorId(int directorId);
    int changeMovieEarnings(int id, double newEarnings);
    int changeDirector(int movieId, int newDirectorId);
}
