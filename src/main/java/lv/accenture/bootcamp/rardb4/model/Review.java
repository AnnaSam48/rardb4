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
    private String reviewTitle;
    private String movieID;
    @Column(columnDefinition = "text", nullable=false)
    private String reviewText;
    private int userRatingForMovie;
    private String username;
    private Long userId;

    //TODO SERIOUS : Such approach let user do as much rates as he wants (and even on it's own review). Need rework here
    private int reviewRating;
    //private int ratingValue;



    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String movieID, String reviewText, int userRatingForMovie, String username, Long userId, int reviewRating) {
        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.movieID = movieID;
        this.reviewText = reviewText;
        this.userRatingForMovie = userRatingForMovie;
        this.username = username;
        this.userId = userId;
        this.reviewRating = reviewRating;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(int userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", movieID='" + movieID + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", userRatingForMovie=" + userRatingForMovie +
                ", username='" + username + '\'' +
                ", userId=" + userId +
                ", reviewRating=" + reviewRating +
                '}';
    }
}