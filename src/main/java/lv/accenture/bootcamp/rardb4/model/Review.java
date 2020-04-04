package lv.accenture.bootcamp.rardb4.model;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;
    @Length(min =2, message = "*Your review title should be at least two characters long.")
    @NotEmpty(message = "*Please type in your review title")
    private String reviewTitle;
    private String movieID;
    private String movieTitle;
    private String moviePicture;
    @Column(columnDefinition = "text", nullable=false)
    @Length(min =2, message = "*Your review should be at least two characters long.")
    @NotEmpty(message = "*Please type in your review")
    private String reviewText;
    private int userRatingForMovie;
    private String username;
    private Long userId;
    private int reviewRating;


    public Review() {
    }

    public Review(Long reviewID, @Length(min = 2,
                  message = "*Your review title should be at least two characters long.")
                  @NotEmpty(message = "*Please type in your review title") String reviewTitle,
                  String movieID, @Length(min = 2, message = "*Your review should be at least two characters long.")
                  @NotEmpty(message = "*Please type in your review") String reviewText,
                  int userRatingForMovie, String username, Long userId, int reviewRating) {
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

    public void setReviewRating(int reviewRating) { this.reviewRating = reviewRating; }

    public String getMovieTitle() { return movieTitle; }

    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }

    public String getMoviePicture() { return moviePicture; }

    public void setMoviePicture(String moviePicture) { this.moviePicture = moviePicture; }


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