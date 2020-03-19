package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String imdbRating;
    private String DVD;
    private String BoxOffice;
    private String Production;

    public Movie() {
    }

//    public Movie(String imdbID, String title, String year, String genre, String plot, String released, String country,
//                 String poster, String director, String actors){}

    public Movie(String imdbID, String title, String year, String type, String poster, String rated, String released,
                 String runtime, String genre, String director, String writer, String actors, String plot, String language,
                 String country, String awards, String imdbRating, String DVD, String boxOffice, String production) {
        this.imdbID = imdbID;
        Title = title;
        Year = year;
        Type = type;
        Poster = poster;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Plot = plot;
        Language = language;
        Country = country;
        Awards = awards;
        this.imdbRating = imdbRating;
        this.DVD = DVD;
        BoxOffice = boxOffice;
        Production = production;
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

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getRated() {
        return Rated;
    }

    public String getReleased() {
        return Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public String getLanguage() {
        return Language;
    }

    public String getCountry() {
        return Country;
    }

    public String getAwards() {
        return Awards;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imdbID='" + imdbID + '\'' +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Rated='" + Rated + '\'' +
                ", Released='" + Released + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Writer='" + Writer + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Language='" + Language + '\'' +
                ", Country='" + Country + '\'' +
                ", Awards='" + Awards + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", DVD='" + DVD + '\'' +
                ", BoxOffice='" + BoxOffice + '\'' +
                ", Production='" + Production + '\'' +
                '}';
    }
}
