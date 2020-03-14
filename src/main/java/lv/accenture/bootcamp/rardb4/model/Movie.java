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
    private Double imdbRating;
    private Integer rotTomRating;
    private String plot;
    private String actors;
    private String directors;

    public Movie(String imdbID, String Title, String year) {
        this.imdbID = imdbID;
        this.Title = Title;
        this.Year = year;
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
                ", imdbRating=" + imdbRating +
                ", rotTomRating=" + rotTomRating +
                ", plot='" + plot + '\'' +
                ", actors='" + actors + '\'' +
                ", directors='" + directors + '\'' +
                '}';
    }
}
