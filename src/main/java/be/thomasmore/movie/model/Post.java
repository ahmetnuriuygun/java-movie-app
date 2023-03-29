package be.thomasmore.movie.model;

import jakarta.persistence.*;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_seq", allocationSize = 1)
    @Id
   private Integer id;

    private String text;

    private String username;

    @ManyToOne
    private Movies movies;

    public Post(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
