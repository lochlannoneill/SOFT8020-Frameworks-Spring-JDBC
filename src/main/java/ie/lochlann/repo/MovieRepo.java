package ie.lochlann.repo;

import ie.lochlann.entities.Movie;

import java.util.List;

public interface MovieRepo {
    int count();
    List<Movie> findAll();
//    List<Movie> getAllByDirectorId(int id);
    Movie findById(int id);
    List<Movie> findMoviesByDirector(int id);
    boolean exists(int id);
    boolean existsByName(String title);
    int deleteMovie(int id);
    int createMovie(int movieId, String title, String releaseDate, double earnings, int directorId);
    int changeMovieEarnings(int id, double newEarnings);
    int changeDirector(int movieId, int newDirectorId);
}
