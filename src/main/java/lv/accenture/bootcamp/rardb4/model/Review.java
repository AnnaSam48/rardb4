
package lv.accenture.bootcamp.rardb4.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Component
@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;

    // @Size(min = 2, max = 256)
    private String reviewTitle;

    // @NotNull
    private String movieID;

    //@Size(min = 10, max = 256)
    private String reviewText;

    // @NotNull
    // @PositiveOrZero
    private double userRatingForMovie;
    private String userName;
    private double ratesSum;
    private double reviewRating;
    private String comment;
    private int ratesAmount;


    public Review() {
    }

    public Review(double ratesSum, int ratesAmount, Long reviewID, String reviewTitle, String reviewText, double userRatingForMovie, String movieID, String userName, String comment) {
        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.userRatingForMovie = userRatingForMovie;
        this.userName = userName;
        this.comment = comment;
        this.ratesAmount = ratesAmount;
        this.ratesSum = ratesSum;
    }

    public double getRatesSum() {
        return ratesSum;
    }

    public void setRatesSum(double ratesSum) {
        this.ratesSum = ratesSum;
    }

    public int getRatesAmount() {
        return ratesAmount;
    }

    public void setRatesAmount(int ratesAmount) {
        this.ratesAmount = ratesAmount;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getUserRatingForMovie() {
        return userRatingForMovie;
    }


    public double getReviewRating() {
        return reviewRating;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public void setReviewText(String reviewText) { this.reviewText = reviewText; }

    public void setUserRatingForMovie(double userRatingForMovie) { this.userRatingForMovie = userRatingForMovie; }

    public void setReviewRating(double reviewRating) { this.reviewRating = reviewRating; }

}