package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class MainXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println(context.getMessage("greeting", null, Locale.getDefault()));
        System.out.println(context.getMessage("greeting", null, Locale.FRENCH));
        System.out.println(context.getMessage("greeting", null, Locale.ITALIAN));

        context.getBeansOfType(Director.class).values().forEach(System.out::println);
        context.getBeansOfType(Movie.class).values().forEach(System.out::println);
        context.close();
    }
}
