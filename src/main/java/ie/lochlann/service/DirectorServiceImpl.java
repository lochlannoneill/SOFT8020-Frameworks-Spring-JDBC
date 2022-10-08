package ie.lochlann.service;

import ie.lochlann.entities.Director;
import ie.lochlann.repo.DirectorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Slf4j //lombok allowing logging //FIXME - why is this not working????
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    DirectorRepo directorRepo;

    @Override
    public int count() {
        return directorRepo.count();
    }

    @Override
    public List<Director> findAll() {
        return directorRepo.getAll();
    }

    @Override
    public Optional<Director> findADirector(int id) {
        if (directorRepo.exists(id)) {
            return Optional.of(directorRepo.findById(id));
        }
//        log.warn("Tried to find an id that did not exist"); // FIXME - why is .warn not working?? i have @Slf4j
        return Optional.empty();
    }

    @Override
    public boolean deleteDirector(int id) {
        if (directorRepo.exists(id)) {
            return directorRepo.deleteDirector(id)==1;
        }
//        log.error("Error - Id {0} does not exist. No director was deleted", id); // FIXME - why is .warn not working?? i have @Slf4j
        return false;
    }

    @Override
    public boolean addDirector(Director director) {
        return false;
    }

    @Override
    public boolean changeDirectorActive(int id, boolean active) {
        return false;
    }


}
