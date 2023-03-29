package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Directors;
import be.thomasmore.movie.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface  MovieRepository extends CrudRepository<Movies,Integer> {
   List<Movies> findAll();
Optional<Movies> findFirstByIdLessThanOrderByIdDesc(Integer id);

Optional<Movies> findFirstByIdGreaterThanOrderById(Integer id);

Optional<Movies> findFirstByOrderByIdDesc();

Optional<Movies> findFirstByOrderByIdAsc();

   List<Movies> findByDirectors(Directors directors);




   @Query("SELECT m FROM Movies m " +
           "WHERE ?1 IS NULL OR  LOWER (m.movieName) LIKE LOWER(CONCAT('%',?1,'%'))" +
           "AND (?2 IS NULL OR m.release_date >= ?2)" +
           "AND (?3 IS NULL OR m.release_date <= ?3)" +
           "AND (?4 IS NULL OR m.rank >= ?4)"
   )
   List<Movies> findByMovies(String keyword, Integer min, Integer max, Double imdb);

}
