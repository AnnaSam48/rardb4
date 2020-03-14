package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable {

    //------acquired from API------
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String imdbID;
    private String Title;
    private String Year;
    private String Type;
    private String Poster;

    //----Additional------
    /*private Double imdbRating;
    private Integer rotTomRating;
    private String plot;
    private String actors;
    private String directors;*/

    public Movie(String imdbID, String title, String year, String type, String poster) {
        this.imdbID = imdbID;
        Title = title;
        Year = year;
        Type = type;
        Poster = poster;
    }

    public Movie() {
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getPoster() {
        return Poster;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imdbID='" + imdbID + '\'' +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }
}
