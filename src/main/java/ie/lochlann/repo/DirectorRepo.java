package ie.lochlann.repo;

import ie.lochlann.entities.Director;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface DirectorRepo {
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
