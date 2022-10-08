package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import ie.lochlann.repo.DirectorRepo;
import ie.lochlann.repo.DirectorRepoImpl;
import ie.lochlann.repo.MovieRepo;
import ie.lochlann.repo.MovieRepoImpl;
import ie.lochlann.service.MovieService;
import ie.lochlann.service.MovieServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MainJavaBeans {
    public static void main(String[] args) {
        final String ANSI_TEXT_RESET = "\u001b[0m";
        final String ANSI_TEXT_RED = "\u001b[31m";
        final String ANSI_TEXT_GREEN = "\u001b[32m";
        final String ANSI_TEXT_YELLOW = "\u001b[33m";
        final String ANSI_TEXT_BLUE = "\u001b[34m";
        final String ANSI_TEXT_PURPLE = "\u001b[35m";
        final String ANSI_TEXT_CYAN = "\u001b[36m";
        final String ANSI_BACKGROUND_BLACK = "\uu001b[40m";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        System.out.println(context.getMessage("greeting", null, Locale.getDefault()));
//        System.out.println(context.getMessage("greeting", null, Locale.FRENCH));
//        System.out.println(context.getMessage("greeting", null, Locale.ITALIAN));
//        System.out.println("List beans created in java config file: ");s
//        context.getBeansOfType(Director.class).values().forEach(System.out::println);
//        context.getBeansOfType(Movie.class).values().forEach(System.out::println);

        // COMPLETED - List all directors
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "----------------List all directors----------------" + ANSI_TEXT_RESET);
        DirectorRepo directorRepo = context.getBean(DirectorRepoImpl.class);
        System.out.println("H2 Database Director Count: " + directorRepo.count());
        directorRepo.getAll().forEach(System.out::println);

        // COMPLETED - List all movies(director not needed)
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "----------------List all movies(director not needed)----------------" + ANSI_TEXT_RESET);
        MovieRepo movieRepo = context.getBean(MovieRepoImpl.class);
        System.out.println("H2 Database Movie Count: " + movieRepo.count());
        movieRepo.getAll().forEach(System.out::println);

        // TODO - add a director
//        System.out.println("");
//        System.out.println("----------------Add a director----------------");

        // TODO - add a movie assigning it to a specific director
        // TODO - delete a movie given its ID
        // TODO - delete director given their ID

        // COMPLETED - find a movie by its ID showing all information and its director
        // FIXME - find out how to use the Director Object instead of directorId
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "----------------Find a movie by its ID showing all information and its director----------------" + ANSI_TEXT_RESET);
        MovieService movieService = context.getBean(MovieServiceImpl.class);
        int movieId = 3; //change to 123 to test invalid id
        System.out.println("Find Movie Id: " + movieId);
        movieService.findAMovie(movieId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: " + movieId));

        // TODO - find all movies by a director given the director's ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_RED + "----------------Find all movies by a director given the director's ID----------------" + ANSI_TEXT_RESET);
        int directorId = 1;
        System.out.println("Find Movies With Director Id: " + directorId);
        movieService.findAll().forEach(System.out::println);

        // TODO - change a director's active status given their ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_YELLOW + "----------------Change a director's active status given their ID----------------" + ANSI_TEXT_RESET);

        // TODO - modify a movie's earnings given its ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_YELLOW + "----------------Modify a movie's earnings given its ID----------------" + ANSI_TEXT_RESET);

        // TODO - determine the average income for all movies by a particular director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_YELLOW + "----------------Determine the average income for all movies by a particular director----------------" + ANSI_TEXT_RESET);

        // TODO - determine the number of inactive directors
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_YELLOW + "----------------Determine the number of inactive directors----------------" + ANSI_TEXT_RESET);

        // TODO - determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_YELLOW + "----------------Determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)----------------" + ANSI_TEXT_RESET);


//        context.close(); //keep commented to see the webserver
    }
}
