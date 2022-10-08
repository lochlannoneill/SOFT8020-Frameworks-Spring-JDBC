package ie.lochlann.repo;

import ie.lochlann.entities.Movie;

import java.util.List;

public interface MovieRepo {
    int count();
    List<Movie> getAll();
    Movie findById(int id);
}
