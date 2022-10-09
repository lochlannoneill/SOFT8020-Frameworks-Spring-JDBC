package ie.lochlann.repo;

import ie.lochlann.entities.Movie;

import java.util.List;

public interface MovieRepo {
    int count();
    List<Movie> getAll();
//    List<Movie> getAllByDirectorId(int id);
    Movie findById(int id);
    boolean exists(int id);
    boolean existsByName(String title);
    int deleteMovie(int id);
    int createMovie(Movie newMovie);
    int changeMovieEarnings(int id, double newEarnings);
}
