package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;

    // @Size(min = 2, max = 256, message="Please enter title:")
    private String reviewTitle;

    //   @NotNull
    private String movieID;

    // @Size(min = 10, max = 256, message ="Please write review (at least 10 characters):")
    private String reviewText;

    //     @NotNull
//     @PositiveOrZero
//     @Max(value=10,message = "Please enter valid rating (from 0-10):")
    private int userRatingForMovie;

    private String username;
    private int ratesSum;
    private int reviewRating;
    private int ratesAmount;


    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String reviewText, int userRatingForMovie,
                  String movieID, String userName, int ratesSum, int ratesAmount) {

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

    public String getUserName() {return username;}

    public void setUserName(String userName) {
        this.username = userName;
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

}