package be.thomasmore.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

}
