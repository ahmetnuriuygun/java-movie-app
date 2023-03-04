package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Movies;
import org.springframework.data.repository.CrudRepository;

public interface  MovieRepository extends CrudRepository<Movies,Integer> {
}
