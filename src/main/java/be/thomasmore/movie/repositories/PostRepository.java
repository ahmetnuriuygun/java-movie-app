package be.thomasmore.movie.repositories;

import be.thomasmore.movie.model.Movies;
import be.thomasmore.movie.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    List<Post> findByMovies(Movies movie);
}
