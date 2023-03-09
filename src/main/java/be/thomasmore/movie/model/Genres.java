package be.thomasmore.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class Genres {
    @Id
    private Integer id;

    private String genre;

  @ManyToMany(mappedBy = "genres2")
  private Collection<Movies> movies;

    public Collection<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movies> movies) {
        this.movies = movies;
    }

    public Genres(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @ManyToMany(mappedBy = "genres")
    private Collection<Movies> movies2;

    public Collection<Movies> getMovies2() {
        return movies2;
    }

    public void setMovies2(Collection<Movies> movies2) {
        this.movies2 = movies2;
    }
}
