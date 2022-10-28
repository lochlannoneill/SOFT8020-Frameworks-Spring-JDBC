
import ie.lochlann.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

@ExtendWith(SpringExtension.class) //allows junit(ExtendWith) to use junit(SpringExtension)
@ContextConfiguration(classes = Config.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLanguage {
    @Autowired
    ApplicationContext context;

    @Test
    public void testDefault() {
        String actual = context.getMessage("greeting", null, "Default", Locale.getDefault());
        Assertions.assertAll(
                ()->Assertions.assertEquals("Hello", actual),
                ()->Assertions.assertNotEquals("Wrong", actual)
        );
    }

    @Test
    public void testFrench() {
        String actual = context.getMessage("greeting", null, "Default", Locale.FRENCH);
        Assertions.assertAll(
                ()->Assertions.assertEquals("Bonjour", actual),
                ()->Assertions.assertNotEquals("Wrong", actual)
        );
    }

    @Test
    public void testItalian() {
        String actual = context.getMessage("greeting", null, "Default", Locale.ITALIAN);
        Assertions.assertAll(
                ()->Assertions.assertEquals("Ciao", actual),
                ()->Assertions.assertNotEquals("Wrong", actual)
        );
    }

}
