package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;

public class FullCommentInfo implements Serializable {
//    private String imdbID;
    private Long reviewID;
    private Double reviewRating;
    private String reviewTitle;
//    private String Title;
//    private String Poster;
    private String reviewText;
    private Double userRatingForMovie;
    private String userName ="xxx";
    private Long commentID;
    private String commentText;
    private String commentUsername;
    private String timestamp;

    public FullCommentInfo(/*String imdbID,*/ Long reviewID, Double reviewRating, String reviewTitle,
                           /*String title, String poster,*/ String reviewText, Double userRatingForMovie,
                           String userName, Long commentID, String commentText, String commentUsername,
                           String timestamp) {
//        this.imdbID = imdbID;
        this.reviewID = reviewID;
        this.reviewRating = reviewRating;
        this.reviewTitle = reviewTitle;
//        Title = title;
//        Poster = poster;
        this.reviewText = reviewText;
        this.userRatingForMovie = userRatingForMovie;
        this.userName = userName;
        this.commentID = commentID;
        this.commentText = commentText;
        this.commentUsername = commentUsername;
        this.timestamp = timestamp;
    }

//    public String getImdbID() {
//        return imdbID;
//    }
//
//    public void setImdbID(String imdbID) {
//        this.imdbID = imdbID;
//    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
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

//    public String getTitle() {
//        return Title;
//    }
//
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//    public String getPoster() {
//        return Poster;
//    }
//
//    public void setPoster(String poster) {
//        Poster = poster;
//    }

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

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentUsername() {
        return commentUsername;
    }

    public void setCommentUsername(String commentUsername) {
        this.commentUsername = commentUsername;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
