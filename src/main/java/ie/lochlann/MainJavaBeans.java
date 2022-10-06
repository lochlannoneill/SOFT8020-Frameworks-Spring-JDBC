package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import ie.lochlann.repo.DirectorRepo;
import ie.lochlann.repo.DirectorRepoImpl;
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

        DirectorRepo directorRepo = context.getBean(DirectorRepoImpl.class);
        System.out.println(directorRepo.count());
        directorRepo.getAll().forEach(System.out::println);

        System.out.println(directorRepo.findById(1));

//        context.close(); //keep commented to see the webserver
    }
}
