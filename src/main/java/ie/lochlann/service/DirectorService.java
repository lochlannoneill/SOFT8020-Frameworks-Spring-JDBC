package ie.lochlann.service;

import ie.lochlann.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    int count();
    List<Director> findAll();
    Optional<Director> findADirector(int id);
    boolean deleteDirector(int id);
    boolean addDirector(Director director);
    boolean changeDirectorActive(int id, boolean newActive);
    double getAverageEarningsByDirector (int id);
    int getInactiveCount();
}
