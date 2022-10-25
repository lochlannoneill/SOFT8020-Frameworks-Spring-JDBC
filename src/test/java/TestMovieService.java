import ie.lochlann.Config;
import ie.lochlann.entities.Movie;
import ie.lochlann.service.MovieService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMovieService {

    @Autowired
    MovieService movieService;

    // COMPLETED - UNIT TEST -> MovieService - Add movie
    @Test
    @Order(3)
    public void add() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(true, movieService.addMovie(new Movie(22, "UnitTest_Successful", "16 October 2022", 1337, 1))), //successful - return true
                ()->Assertions.assertEquals(false, movieService.addMovie(new Movie(1, "UnitTest_Unsuccessful", "16 October 2022", 1337, 1))) //unsuccessful - return false
        );
    }

    // TODO - UNIT TEST -> MovieService - Find all movies given directorId
    @Test
    @Order(1)
    public void findMoviesByDirector() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(true, movieService.addMovie(new Movie(22, "UnitTest_Successful", "16 October 2022", 1337, 1))), //successful - return true
                ()->Assertions.assertEquals(false, movieService.addMovie(new Movie(1, "UnitTest_Unsuccessful", "16 October 2022", 1337, 1))) //unsuccessful - return false
        );
    }

    // TODO - UNIT TEST -> MovieService - Update movietakings given directorId
    @Test
    @Order(2)
    public void changeEarnings() {
        // TODO
    }

}
