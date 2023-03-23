package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Actors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActorsRepository extends CrudRepository<Actors,Integer> {
    List<Actors> findAll();

    Optional<Actors> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Actors> findFirstByIdGreaterThanOrderById(Integer id);

    Optional<Actors> findFirstByOrderByIdDesc();

    Optional<Actors> findFirstByOrderByIdAsc();

    List<Actors> findByFirstNameContainingIgnoreCase(String keyword);
}
