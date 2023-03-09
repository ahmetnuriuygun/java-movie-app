package be.thomasmore.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class Movies {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(length= 10000)
    private String poster;
    private String movieName;
    private int release_date;
    private double rank;

    private String description;

   @ManyToMany
   private Collection<Genres> genres;


    public Collection<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genres> genres) {
        this.genres = genres;
    }

    public Movies(){
    }

    public Movies(String movieName) {
        this.movieName = movieName;

    }

    public String getPoster() {
        return poster;
    }


    public void setPoster(String poster) {
        this.poster = poster;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String venueName) {
        this.movieName = venueName;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int capacity) {
        this.release_date = capacity;
    }



    public double getRank() {
        return rank;
    }

    public void setRank(double distanceFromPublicTransportInKm) {
        this.rank = distanceFromPublicTransportInKm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToMany
    private Collection<Genres> genres2;

    public Collection<Genres> getGenres2() {
        return genres2;
    }

    public void setGenres2(Collection<Genres> genres2) {
        this.genres2 = genres2;
    }
}
