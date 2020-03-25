package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class ReadyReview {

    private String imdbID;
    private Long reviewID;
    private int reviewRating;
    private String reviewTitle;
    private String movieTitle;
    private String poster;
    private String reviewText;
    private int userRatingForMovie;
    private String userName;



    public ReadyReview(String imdbID, Long reviewID, int reviewRating, String reviewTitle,
                       String movieTitle, String poster, String reviewText, int userRatingForMovie,
                       String userName) {

        this.imdbID = imdbID;
        this.reviewID = reviewID;
        this.reviewRating = reviewRating;
        this.reviewTitle = reviewTitle;
        this.movieTitle = movieTitle;
        this.poster = poster;
        this.reviewText = reviewText;
        this.userRatingForMovie = userRatingForMovie;
        this.userName = userName;
    }


    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
