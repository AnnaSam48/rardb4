package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;
    private String reviewTitle;
    private String reviewText;
    private String movieID;
    private double userRatingForMovie;
    private double reviewRating;


    public Review() {
    }

    public Review(Long reviewID, String reviewTitle,  String reviewText, double userRatingForMovie, String movieID) {
        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.userRatingForMovie = getUserRatingForMovie();
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getMovieID() {
        return movieID;
    }

    public double getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(double userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }


    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }
}
