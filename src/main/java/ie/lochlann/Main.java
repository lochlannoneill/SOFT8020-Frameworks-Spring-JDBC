package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.HighestEarnings;
import ie.lochlann.entities.Movie;
import ie.lochlann.service.DirectorService;
import ie.lochlann.service.DirectorServiceImpl;
import ie.lochlann.service.MovieService;
import ie.lochlann.service.MovieServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Main {
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
        DirectorService directorService = context.getBean(DirectorServiceImpl.class);
        MovieService movieService = context.getBean(MovieServiceImpl.class);

        System.out.println(context.getMessage("greeting", null, Locale.getDefault()));
        System.out.println(context.getMessage("greeting", null, Locale.FRENCH));
        System.out.println(context.getMessage("greeting", null, Locale.ITALIAN));

        // COMPLETED - List all directors
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - List all directors" + ANSI_TEXT_RESET);
        System.out.println("H2 Database Director Count: " + directorService.count());
        directorService.findAll().forEach(System.out::println);

        // COMPLETED - List all movies(director not needed)
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - List all movies(director not needed)" + ANSI_TEXT_RESET);
        System.out.println("H2 Database Movie Count: " + movieService.count());
        movieService.findAll().forEach(System.out::println);

        // COMPLETED - Add a director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Add a director" + ANSI_TEXT_RESET);
        int newDirectorId = 99;
        directorService.findADirector(newDirectorId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + newDirectorId + "'"));
        System.out.println("Creating new director with id '" + newDirectorId + "'...");
        directorService.addDirector(new Director(newDirectorId, "test", "test", false));
        directorService.findADirector(newDirectorId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + newDirectorId + "'"));

        // COMPLETED - Add a movie assigning it to a specific director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Add a movie assigning it to a specific director" + ANSI_TEXT_RESET);
        int newMovieId = 99;
        movieService.findAMovie(newMovieId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + newMovieId + "'"));
        System.out.println("Creating new movie with id '" + newMovieId + "', assigned to director with id '" + newDirectorId + "'");
        movieService.addMovie(new Movie(newMovieId, "Test: The Movie", "October 9, 2022", 65, newDirectorId));
        movieService.findAMovie(newMovieId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + newMovieId + "'"));

        // COMPLETED - Delete a movie given its ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Delete a movie given its ID" + ANSI_TEXT_RESET);
        int deleteMovieID = 5;
        movieService.findAMovie(deleteMovieID).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + deleteMovieID +"'"));
        System.out.println("Deleting movie with id '" + deleteMovieID + "'...");
        movieService.deleteMovie(deleteMovieID);
        movieService.findAMovie(deleteMovieID).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + deleteMovieID + "'"));

        // COMPLETED - Delete director given their ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Delete a director given its ID" + ANSI_TEXT_RESET);
        int deleteDirectorID = 3;
        directorService.findADirector(deleteDirectorID).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + deleteDirectorID + "'"));
        System.out.println("Deleting director with id '" + deleteDirectorID + "'...");
        directorService.deleteDirector(deleteDirectorID);
        directorService.findADirector(deleteDirectorID).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + deleteDirectorID + "'"));

        // COMPLETED - find a movie by its ID showing all information and its director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Find a movie by its ID showing all information and its director" + ANSI_TEXT_RESET);
        int movieId = 3;
        System.out.println("Find Movie By Id: " + movieId);
        movieService.findAMovie(movieId).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + movieId + "'"));

        // COMPLETED - Find all movies by a director given the director's ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Find all movies by a director given the director's ID" + ANSI_TEXT_RESET);
        int directorId = 1;
        System.out.println("Find Movies By Director Id: " + directorId);
        movieService.findMoviesByDirector(directorId).forEach(System.out::println);

        // COMPLETED - Change a director's active status given their ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN+ "COMPLETED - Change a director's active status given their ID" + ANSI_TEXT_RESET);
        int changeActiveid = 1;
        directorService.findADirector(changeActiveid).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + changeActiveid + "'"));
        System.out.println("Changing director id '" + changeActiveid + "' activity status to 'false'");
        directorService.changeDirectorActive(changeActiveid, false);
        directorService.findADirector(changeActiveid).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Director Id: '" + changeActiveid + "'"));


        // COMPLETED - Modify a movie's earnings given its ID
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Modify a movie's earnings given its ID" + ANSI_TEXT_RESET);
        int changeEarningsid = 3;
        movieService.findAMovie(changeEarningsid).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + changeEarningsid + "'"));
        System.out.println("Changing movie id '" + changeEarningsid + "' earnings to '999'");
        movieService.changeMovieEarnings(changeEarningsid, 999);
        movieService.findAMovie(changeEarningsid).ifPresentOrElse(System.out::println,() -> System.out.println("Error - Invalid Movie Id: '" + changeEarningsid + "'"));

        // COMPLETED - Determine the average income for all movies by a particular director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Determine the average income for all movies by a particular director" + ANSI_TEXT_RESET);
        //int determineAverageId = 1;
        System.out.println("Average movie earnings of director id: " + 1);
        movieService.findMoviesByDirector(directorId).forEach(System.out::println);
        System.out.println("Average earnings: " + directorService.getAverageEarningsByDirector(1));

        // COMPLETED - Determine the number of inactive directors
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - Determine the number of inactive directors" + ANSI_TEXT_RESET);
        System.out.println("Inactive Director Count: " + directorService.getInactiveCount());
        directorService.findAll().forEach(System.out::println);

        // COMPLETED - Determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "Determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)" + ANSI_TEXT_RESET);
        HighestEarnings he = movieService.findHighestEarningsAndDirectorName();
        String highest_title = he.title();
        Double highest_earnings = he.earnings();
        String highest_dname = he.directorName();
        System.out.println("Movie Title: " + highest_title + "\nMovie Earnings: " + highest_earnings + "\nDirector Name: " + highest_dname);
//        System.out.println(movieService.findHighestEarningsByDirectorId(directorId));

        // COMPLETED - UNIT TEST -> Messages in different languages
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> Messages in different languages" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - Delete a director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - Delete a director" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - Add a director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - Add a director" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - Change the status of the director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - Change the status of the director" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - The average income
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - The average income" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - Number of inactive directors
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - Number of inactive directors" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> DirectorRepo - Highest earnings along with the director
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> DirectorRepo - Highest earnings along with the director" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> MovieService - Add movie
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> MovieService - Add movie" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> MovieService - Find all movies given directorId
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> MovieService - Find all movies given directorId" + ANSI_TEXT_RESET);

        // COMPLETED - UNIT TEST -> MovieService - Update movie takings given movieId
        System.out.println("\n" + ANSI_BACKGROUND_BLACK + ANSI_TEXT_GREEN + "COMPLETED - UNIT TEST -> MovieService - Update movie takings given movieId" + ANSI_TEXT_RESET);

        //context.close(); //keep commented to see the webserverA
    }
}
