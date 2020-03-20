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

    private String movieID;

    //@NotNull
    //@Size(min = 2, max = 250)
    private String reviewTitle;


    //@Size(min = 2, max = 20, message = "Cat name should be longer than 2 letters")
    private String reviewText;

    // @NotNull
    // @PositiveOrZero
    private double userRatingForMovie;

    private double reviewRating = 0.0;


    public Review() {
    }

    public Review(Long reviewID, String movieID, String reviewTitle, String reviewText, double userRatingForMovie, double reviewRating) {
        this.reviewID = reviewID;
        this.movieID = movieID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.userRatingForMovie = userRatingForMovie;
        this.reviewRating = reviewRating;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(double userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }
}
