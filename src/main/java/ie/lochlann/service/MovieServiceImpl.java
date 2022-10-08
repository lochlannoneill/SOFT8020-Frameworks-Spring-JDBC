package ie.lochlann.service;

import ie.lochlann.entities.Movie;
import ie.lochlann.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
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
    public boolean addMovie(Movie newMovie) {
        if (movieRepo.existsByName(newMovie.getTitle()) ) {
//            log.error(MessageFormat.format("Could not add movie. Duplicate Name: {0}", newMovie.getTitle()));
            return false;
        }
        if (movieRepo.exists(newMovie.getMovieId())) {
//            log.error(MessageFormat.format("Could not add movie. Duplicate Id: {0}", newMovie.getMovieId()));
            return false;
        }
        return movieRepo.createMovie(newMovie) == 1;
    }

    @Override
    public boolean changeMovieEarnings(int id, double earnings) {
        return false;
    }
}
