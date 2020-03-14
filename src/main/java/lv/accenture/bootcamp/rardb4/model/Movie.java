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
    private String Poster;
    private String Type;

    //----Additional------
    private Double imdbRating;
    private Integer rotTomRating;
   private String plot;
    //private String actors;
    //private String directors;

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

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
       Year = year;
    }

    public String getPoster() {
       return Poster;
    }

   public void setPoster(String poster) {
        this.Poster = poster;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }
//
//    public Double getImdbRating() {
//        return imdbRating;
//    }
//
//    public void setImdbRating(Double imdbRating) {
//        this.imdbRating = imdbRating;
//    }
//
//    public Integer getRotTomRating() {
//        return rotTomRating;
//    }
//
//    public void setRotTomRating(Integer rotTomRating) {
//        this.rotTomRating = rotTomRating;
//    }
//
//    public String getPlot() {
//        return plot;
//    }
//
//    public void setPlot(String plot) {
//        this.plot = plot;
//    }
//
////    public String getActors() {
////        return actors;
////    }

////    public void setActors(String actors) {
////        this.actors = actors;
////    }
////
////    public String getDirectors() {
////        return directors;
////    }
////
////    public void setDirectors(String directors) {
////        this.directors = directors;
//    }
}
