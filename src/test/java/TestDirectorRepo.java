import ie.lochlann.Config;
import ie.lochlann.entities.Director;
import ie.lochlann.repo.DirectorRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ComponentScan("ie.lochlann")
public class TestDirectorRepo {
    @Autowired
    DirectorRepo directorRepo;

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
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.createDirector(new Director(44, "UnitTest", "UnitTest", true))), //successful - return 1
                ()->Assertions.assertThrows(DuplicateKeyException.class, ()-> directorRepo.createDirector(new Director(1, "Failed", "Failed", true)) //unsuccessful - return 0

                ));
    }

    @Test
    @Order(1)
    public void changeStatus() {
        // TODO
    }
}
