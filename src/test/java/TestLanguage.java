
import ie.lochlann.Config;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) //allows junit(ExtendWith) to use junit(SpringExtension)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLanguage {
    @Autowired
//    ApplicationContext context;
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @Test
    public void testFrenchSuccess() {
        String actual = context.getMessage("greeting", null, "Default", Locale.FRENCH);
        assertEquals("Bonjour", actual);
    }

    @Test
    public void testFrenchError() {
        String actual = context.getMessage("greeting", null, "Default", Locale.FRENCH);
        assertEquals("Ciao", actual);
    }

    @Test
    public void testItalianSuccess() {
        String actual = context.getMessage("greeting", null, "Default", Locale.FRENCH);
        assertEquals("Ciao", actual);
    }

    @Test
    public void testItalianError() {
        String actual = context.getMessage("greeting", null, "Default", Locale.FRENCH);
        assertEquals("Bonjour", actual);
    }
}
