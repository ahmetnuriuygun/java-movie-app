package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Directors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorsRepository extends CrudRepository<Directors,Integer> {
    List<Directors> findAll();

    Optional<Directors> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Directors> findFirstByIdGreaterThanOrderById(Integer id);

    Optional<Directors> findFirstByOrderByIdDesc();

    Optional<Directors> findFirstByOrderByIdAsc();




    List<Directors> findByOscar(boolean isOcar);
}
