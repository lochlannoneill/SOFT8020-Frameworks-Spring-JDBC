package ie.lochlann.service;

import ie.lochlann.entities.HighestEarnings;
import ie.lochlann.entities.Movie;
import ie.lochlann.entities.Result;
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

//    @Override
//    public List<Movie> findAll() {
//        return movieRepo.findAll();
//    }
    @Override
    public List<Result> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> findAMovie(int id) {
        if (movieRepo.exists(id)) {
            return Optional.of(movieRepo.findById(id));
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> findMoviesByDirector(int id) {
        return movieRepo.findMoviesByDirector(id);
    }

    @Override
    public HighestEarnings findHighestEarningsAndDirectorName() {
        return movieRepo.findHighestEarningsAndDirectorName();
    }

    @Override
    public Result findMovieTitleAndDirectorName(int movieId) {
        return movieRepo.findMovieTitleAndDirectorName(movieId);
    }

    @Override
    public double getAverageEarningsByDirectorId(int directorId) {
        return movieRepo.getAverageEarningsByDirectorId(directorId);
    }

    @Override
    public boolean deleteMovie(int id) {
        if (movieRepo.exists(id)) {
            return movieRepo.deleteMovie(id)==1;
        }
//        log.error(MessageFormat.format("Error - Id {0} does not exist. No director was deleted", id)); // FIXME - why is .warn not working?? i have @Slf4j
        return false;
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (movieRepo.exists(movie.getMovieId()) ) {
//            log.error(MessageFormat.format("Could not add director. Duplicate Id: {0}", newDirector.getDirectorId())); //FIXME
            return false;
        }
        return movieRepo.addMovie(movie) == 1;
    }

    @Override
    public boolean changeMovieEarnings(int id, double newEarnings) {
        if (! movieRepo.exists(id)) {
//            log.error(MessageFormat.format("Cannot change movie earnings. Movie Id {0} does not exist", id)); //FIXME
            return false;
        }
        return movieRepo.changeMovieEarnings(id, newEarnings) == 1;
    }

    @Override
    public boolean changeDirector(int movieId, int newDirectorId) {
        if (! movieRepo.exists(movieId)) {
//            log.error(MessageFormat.format("Cannot change movie director. Movie Id {0} does not exist", id)); //FIXME
            return false;
        }
        return movieRepo.changeMovieEarnings(movieId, newDirectorId) == 1;
    }
}
