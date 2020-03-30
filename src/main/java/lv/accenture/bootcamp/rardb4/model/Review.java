package lv.accenture.bootcamp.rardb4.model;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;
//    @Length(min = 2, max = 256, message="Please enter title:")
//    @NotNull(message = "Please enter your review title (it should be at least 2 characters long):")
    private String reviewTitle;
    private String movieID;
//    @Length(min = 10, max = 3000, message ="Please write review (at least 10 characters):")
//    @NotNull(message = "Please enter your review!")

    @Column(columnDefinition = "text", nullable=false)
    private String reviewText;
    private int userRatingForMovie;
    private String username;

    //TODO SERIOUS : Such approach let user do as much rates as he wants (and even on it's own review). Need rework here
    private int reviewRating;
    private int ratesSum;
    private int ratesAmount;


    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String reviewText, int userRatingForMovie,
                  String movieID, String userName, int ratesSum, int ratesAmount/*, List<Comment>comments*/) {

        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.userRatingForMovie = userRatingForMovie;
        this.username = userName;
        this.ratesAmount = ratesAmount;
        this.ratesSum = ratesSum;
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

    public int getUserRatingForMovie() {
        return userRatingForMovie;
    }


    public int getReviewRating() {
        return reviewRating;
    }

    public int getRatesSum() {
        return ratesSum;
    }

    public void setRatesSum(int ratesSum) {
        this.ratesSum = ratesSum;
    }

    public int getRatesAmount() {
        return ratesAmount;
    }

    public void setRatesAmount(int ratesAmount) {
        this.ratesAmount = ratesAmount;
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

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setUserRatingForMovie(int userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}