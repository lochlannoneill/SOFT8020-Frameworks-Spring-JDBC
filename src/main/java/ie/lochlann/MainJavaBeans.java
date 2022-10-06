package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainJavaBeans {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println(context.getMessage("greeting", null, Locale.getDefault()));
        System.out.println(context.getMessage("greeting", null, Locale.FRENCH));
        System.out.println(context.getMessage("greeting", null, Locale.ITALIAN));

        context.getBeansOfType(Director.class).values().forEach(System.out::println);
        context.getBeansOfType(Movie.class).values().forEach(System.out::println);
        context.close();
    }
}
