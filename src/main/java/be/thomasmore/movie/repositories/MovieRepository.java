package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  MovieRepository extends CrudRepository<Movies,Integer> {
   List<Movies> findMoviesByMovieNameContainingIgnoreCase(String keyword);


   @Query("SELECT m FROM Movies m WHERE(LOWER(m.movieName)LIKE LOWER(CONCAT('%',:keyword,'%')))")
           List<Movies> findArtistsContainingKeyword(@Param("keyword")String keyword);
}
