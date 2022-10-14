import ie.lochlann.Config;
import ie.lochlann.entities.Director;
import ie.lochlann.repo.DirectorRepo;
import ie.lochlann.repo.MovieRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ComponentScan("ie.lochlann")
public class TestDirectorRepo {

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    @Autowired
    DirectorRepo directorRepo;
//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//    DirectorRepo directorRepo = context.getBean(DirectorRepo.class);


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;




//    all outcomes for the following methods in the repository layer (you may use Assertions.assertAll() or write separate tests for each outcome)
//    delete a director
//    add a director
//    change the status of the director

    @Test
    @Order(3)
    public void delete() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.deleteDirector(1)), //successful - return 1
                ()->Assertions.assertEquals(0, directorRepo.deleteDirector(22) //unsuccessful - return 0

        ));
    }

    @Test
    @Order(2)
    public void add() {
        // TODO
    }

    @Test
    @Order(1)
    public void changeStatus() {
        // TODO
    }
}
