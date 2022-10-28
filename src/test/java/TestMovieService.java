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

    @Test
    @Order(1)
    public void testRepo() {
        Assertions.assertNotNull(movieService);
    }

    // COMPLETED - UNIT TEST -> MovieService - Add movie
    @Test
    @Order(5)
    public void add() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(true, movieService.addMovie(new Movie(22, "UnitTest_Successful", "16 October 2022", 1337, 1))), //successful - return true
                ()->Assertions.assertEquals(false, movieService.addMovie(new Movie(1, "UnitTest_Unsuccessful", "16 October 2022", 1337, 1))) //unsuccessful - return false
        );
    }

    // COMPLETED - UNIT TEST -> MovieService - Find all movies given directorId
    @Test
    @Order(4)
    public void findMoviesByDirector() {
        Assertions.assertAll(
                ()->Assertions.assertNotNull(movieService.findMoviesByDirector(1))
        );
    }

    // COMPLETED - UNIT TEST -> DirectorRepo - The average income by directorId
    @Test
    @Order(2)
    public void averageIncome() {
        Assertions.assertAll(
                ()->Assertions.assertNotNull(movieService.getAverageEarningsByDirectorId(1)),
                ()->Assertions.assertEquals(6.7725E8, movieService.getAverageEarningsByDirectorId(1))
        );
    }

    // COMPLETED - UNIT TEST -> MovieService - Update movietakings given movieId
    @Test
    @Order(6)
    public void changeEarnings() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(true, movieService.changeMovieEarnings(3, 999)), //successful - return true
                ()->Assertions.assertEquals(false, movieService.changeMovieEarnings(77, 999)) //unsuccessful - return false
        );
    }

    // COMPLETED - UNIT TEST -> Highest earnings along with the director
    @Test
    @Order(3)
    public void getHighestEarningMovieAndDirectorName() {
        Assertions.assertAll(
                ()->Assertions.assertNotNull(movieService.findHighestEarningsAndDirectorName()),
                ()->Assertions.assertEquals("Lochlann O'Neill", movieService.findHighestEarningsAndDirectorName().directorName()) //movieRepo -> concat(d.fname, ' ', d.lname) as dname
        );
    }

}
