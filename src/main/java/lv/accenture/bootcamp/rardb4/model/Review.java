package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;

   // @Size(min = 2, max = 256)
    private String reviewTitle;

   // @NotNull
    private String movieID;

  //  @Size(min = 2, max = 256)
    private String movieTitle;

    private String moviePicture;

    //@Size(min = 10, max = 256)
    private String reviewText;

   // @NotNull
   // @PositiveOrZero
    private double userRatingForMovie;

    private double reviewRating = 0.0;


    public Review() {
    }

    public Review(Long reviewID, String movieTitle, String moviePicture, String reviewTitle, String reviewText, double userRatingForMovie, String movieID) {

        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.moviePicture = moviePicture;
        this.userRatingForMovie = userRatingForMovie;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public double getReviewRating() {
        return reviewRating;
    }


    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }

    public void setMoviePicture(String moviePicture) { this.moviePicture = moviePicture; }

    public void setReviewText(String reviewText) { this.reviewText = reviewText; }

    public void setUserRatingForMovie(double userRatingForMovie) { this.userRatingForMovie = userRatingForMovie; }

    public void setReviewRating(double reviewRating) { this.reviewRating = reviewRating; }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", moviePicture='" + moviePicture + '\'' +
                ", movieID='" + movieID + '\'' +
                ", userRatingForMovie=" + userRatingForMovie +
                ", reviewRating=" + reviewRating +
                '}';
    }
}
