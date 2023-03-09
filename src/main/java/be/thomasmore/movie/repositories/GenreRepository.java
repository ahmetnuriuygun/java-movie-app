package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Genres;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genres,Integer> {



    List<Genres> findByMoviesId(Integer id);
}
