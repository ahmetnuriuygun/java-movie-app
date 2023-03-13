package be.thomasmore.movie.model;

import jakarta.persistence.*;

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


    @ManyToOne
    private Directors directors;

    public Collection<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genres> genres) {
        this.genres = genres;
    }



    @ManyToMany
    private Collection<Genres> genres2;

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


    public Directors getDirectors() {
        return directors;
    }

    public void setDirectors(Directors directors) {
        this.directors = directors;
    }



    public Collection<Genres> getGenres2() {
        return genres2;
    }

    public void setGenres2(Collection<Genres> genres2) {
        this.genres2 = genres2;
    }
}
