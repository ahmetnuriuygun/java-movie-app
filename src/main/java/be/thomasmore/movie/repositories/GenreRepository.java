package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Genres;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genres,Integer> {



    List<Genres> findByMoviesId(Integer id);

    Optional<Genres> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Genres> findFirstByIdGreaterThanOrderById(Integer id);

    Optional<Genres> findFirstByOrderByIdDesc();

    Optional<Genres> findFirstByOrderByIdAsc();




}
