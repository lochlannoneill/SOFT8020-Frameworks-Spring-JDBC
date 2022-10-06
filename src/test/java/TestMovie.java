import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //allows junit(ExtendWith) to use junit(SpringExtension)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
public class TestMovie {
    @Autowired
    ApplicationContext context;

    @Test
    public void testMoiveBean() {
        Movie testFaculty = context.getBean(Movie.class);
        Assertions.assertNotNull(testFaculty);
    }

    @Test
    public void testMovieBeanNameSuccess() {
        Movie testMovie = context.getBean(Movie.class);
        Assertions.assertEquals("The Lord of the Rings: The Fellowship of the Ring", testMovie.getTitle());
    }

    @Test
    public void testMovieBeanNameError() {
        Movie testMovie = context.getBean(Movie.class);
        Assertions.assertEquals("Titanic", testMovie.getTitle());
    }

}

