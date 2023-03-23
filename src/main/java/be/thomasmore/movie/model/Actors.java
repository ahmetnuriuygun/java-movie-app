package be.thomasmore.movie.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class Actors {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String gender;


    private int filmCount;

    @ManyToMany(mappedBy = "actor")
    private Collection<Movies> movies;



    public Actors(){

    }





    public Collection<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movies> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

}
