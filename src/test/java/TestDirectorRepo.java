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
public class TestDirectorRepo {
    @Autowired
    DirectorRepo directorRepo;

    @Test
    @Order(1)
    public void testRepo() {
        Assertions.assertNotNull(directorRepo);
    }

    // COMPLETED - UNIT TEST -> Delete a director
    @Test
    @Order(3)
    public void delete() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.deleteDirector(44)), //successful - return 1
                ()->Assertions.assertEquals(0, directorRepo.deleteDirector(22)) //unsuccessful - return 0
        );
    }

    // COMPLETED - UNIT TEST -> Add a director
    @Test
    @Order(2)
    public void add() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.createDirector(new Director(44, "UnitTest", "UnitTest", true))), //successful - return 1
                ()->Assertions.assertThrows(DuplicateKeyException.class, ()-> directorRepo.createDirector(new Director(1, "Failed", "Failed", true))) //unsuccessful - return 0
        );
    }

    // COMPLETED - UNIT TEST -> Change the status of the director
    @Test
    @Order(6)
    public void changeStatus() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.changeDirectorActive(1, false)), //successful - return 1
                ()->Assertions.assertEquals(1, directorRepo.changeDirectorActive(3, true)), //successful - return 1
                ()->Assertions.assertEquals(0, directorRepo.changeDirectorActive(55, false)) //unsuccessful - return 0
        );
    }

    // COMPLETED - UNIT TEST -> Number of inactive directors
    @Test
    @Order(4)
    public void countInactive() {
        Assertions.assertAll(
                ()->Assertions.assertEquals(1, directorRepo.getInactiveCount())
        );
    }

}
