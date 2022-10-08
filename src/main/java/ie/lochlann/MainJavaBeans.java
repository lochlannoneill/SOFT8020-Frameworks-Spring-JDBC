package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import ie.lochlann.repo.DirectorRepo;
import ie.lochlann.repo.DirectorRepoImpl;
import ie.lochlann.repo.MovieRepo;
import ie.lochlann.repo.MovieRepoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainJavaBeans {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

//        System.out.println(context.getMessage("greeting", null, Locale.getDefault()));
//        System.out.println(context.getMessage("greeting", null, Locale.FRENCH));
//        System.out.println(context.getMessage("greeting", null, Locale.ITALIAN));
//        System.out.println("List beans created in java config file: ");s
//        context.getBeansOfType(Director.class).values().forEach(System.out::println);
//        context.getBeansOfType(Movie.class).values().forEach(System.out::println);

        // COMPLETED - List all directors
        DirectorRepo directorRepo = context.getBean(DirectorRepoImpl.class);
        System.out.println("H2 Director Count: " + directorRepo.count());
        System.out.println("H2 Director List: ");
        directorRepo.getAll().forEach(System.out::println);
        System.out.println("");

        // TODO - List all movies(director not needed)
        MovieRepo movieRepo = context.getBean(MovieRepoImpl.class);
        System.out.println("H2 Movie Count: " + movieRepo.count());
        System.out.println("H2 Movie List: ");
        movieRepo.getAll().forEach(System.out::println);
        System.out.println("");

        // TODO - add a director
        // TODO - add a moveie assigning it to a specific director
        // TODO - delete a movie given its ID
        // TODO - delete director given their ID
        // TODO - find a movie by its ID showing all information and its director
        // TODO - find all movies by a director given the director's ID
        // TODO - change a director's active status given their ID
        // TODO - modify a movie's earnings given its ID
        // TODO - determine the average income for all movies by a particular director
        // TODO - determine the number of inactive directors
        // TODO - determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)

        System.out.println("");
        System.out.println(directorRepo.findById(1));

//        context.close(); //keep commented to see the webserver
    }
}
