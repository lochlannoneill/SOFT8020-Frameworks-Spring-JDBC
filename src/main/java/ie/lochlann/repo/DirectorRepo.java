package ie.lochlann.repo;

import ie.lochlann.entities.Director;

import java.util.List;

public interface DirectorRepo {
    int count();
    List<Director> getAll();
    Director findById(int id);
    boolean exists(int id);
    boolean existsByName(String name);
//    int deleteDirector(int id);
//    int createDirector(Director newDirector);
}
