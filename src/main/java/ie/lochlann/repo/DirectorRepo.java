package ie.lochlann.repo;

import ie.lochlann.entities.Director;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface DirectorRepo {

    // TODO - Determine the average income for all movies by a particular director
    // TODO - Determine the number of inactive directors
    // TODO - Determine the name of the movie with the highest earnings along with the name of its director (you might use a record class here)

    int count();
    List<Director> getAll();
    Director findById(int id);
    boolean exists(int id);
    boolean existsByName(String name);

    int deleteDirector(int id);
    int createDirector(Director newDirector);
    int changeDirectorActive(int id, boolean newActive);
    double getAverageEarningsByDirector(int id);
    int getInactiveCount();
}
