package ie.lochlann.service;

import ie.lochlann.entities.Movie;
import ie.lochlann.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepo movieRepo;

    @Override
    public int count() {
        return movieRepo.count();
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.getAll();
    }

//    @Override
//    public List<Movie> findAllByDirectorId(int id) {
//        return movieRepo.getAllByDirectorId(id);
//    }

    @Override
    public Optional<Movie> findAMovie(int id) {
        if (movieRepo.exists(id)) {
            return Optional.of(movieRepo.findById(id));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteMovie(int id) {
        return false;
    }

    @Override
    public boolean addMovie(int movieId, int directorId) {
        return false;
    }

    @Override
    public boolean changeMovieEarnings(int id, double earnings) {
        return false;
    }
}
