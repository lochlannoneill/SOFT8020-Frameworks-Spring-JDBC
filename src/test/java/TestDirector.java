import ie.lochlann.entities.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //allows junit(ExtendWith) to use junit(SpringExtension)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
public class TestDirector {
    @Autowired
    ApplicationContext context;

    @Test
    public void testDirectorBean() {
        Director testDirector = context.getBean(Director.class);
        Assertions.assertNotNull(testDirector);
    }

    @Test
    public void testDirectorBeanName_Success() {
        Director testDirector = context.getBean(Director.class);
        Assertions.assertEquals("Lochlann", testDirector.getFname());
    }

    @Test
    public void testDirectorBeanName_Error() {
        Director testDirector = context.getBean(Director.class);
        Assertions.assertEquals("Cliona", testDirector.getFname());
    }

}

