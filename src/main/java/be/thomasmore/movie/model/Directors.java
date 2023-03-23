package be.thomasmore.movie.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Directors {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String directorName;
    private Date born;
    private boolean oscar;

    @Column(length=50000)
    private String image;

    public Directors(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String name) {
        this.directorName = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public boolean isOscar() {
        return oscar;
    }

    public void setOscar(boolean oscar) {
        this.oscar = oscar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
