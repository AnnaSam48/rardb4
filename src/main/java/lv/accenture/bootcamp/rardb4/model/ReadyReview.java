package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;


public class ReadyReview implements Serializable {

    private String imdbID;
    private Double reviewRating;
    private String reviewTitle;
    private String Title;
    private String Poster;
    private String reviewText;
    private Double userRatingForMovie;
    private String userName;

    public ReadyReview(String imdbID, double reviewRating, String reviewTitle, String title,
                       String poster, String reviewText, double userRatingForMovie, String userName) {

        this.imdbID = imdbID;
        this.reviewRating = reviewRating;
        this.reviewTitle = reviewTitle;
        Title = title;
        Poster = poster;
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

    public Double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(Double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Double getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(Double userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
