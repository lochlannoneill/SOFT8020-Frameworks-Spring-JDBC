import ie.lochlann.repo.MovieRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestMovieRepo {

    @Autowired
    MovieRepo movieRepo;

//    all outcomes for the following methods in the service layer (you may use Assertions.assertAll() or write separate tests for each outcome)
//    add a movie
//    find all movies by a director given their ID
//    modify a movie's takings given its ID

    @Test
    @Order(3)
    public void delete() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, movieRepo.deleteMovie(1)), //successful - return 1
                ()->Assertions.assertEquals(0, movieRepo.deleteMovie(22)) //unsuccessful - return 0
        // TODO
        );
    }

    @Test
    @Order(1)
    public void findMoviesByDirector() {
        // TODO
    }

    @Test
    @Order(2)
    public void changeEarnings() {
        // TODO
    }

}
