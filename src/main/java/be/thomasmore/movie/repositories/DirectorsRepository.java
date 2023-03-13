package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Directors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DirectorsRepository extends CrudRepository<Directors,Integer> {
    List<Directors> findAll();

//    List<Directors> findByMovies(Movies movie);
}
