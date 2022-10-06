package ie.lochlann.repo;

import ie.lochlann.entities.Director;

import java.util.List;

public interface DirectorRepo {
    int count();
    List<Director> getAll();
    Director findById(int id);
}
