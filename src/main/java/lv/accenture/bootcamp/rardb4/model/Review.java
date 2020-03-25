package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="reviewid")
    private Long reviewID;
//
//    @Size(min = 2, max = 256, message="Please enter title:")
//    @Column(name = "review_title")
    private String reviewTitle;

//    @NotNull
//    @Column(name = "movieid")
    private String movieID;

//    @Size(min = 10, max = 256, message ="Please write review (at least 10 characters):")
//    @Column(name = "review_text")
    private String reviewText;

//    @NotNull
//    @PositiveOrZero
//    @Max(value=10,message = "Please enter valid rating (from 0-10):")
//    @Column(name = "user_rating_for_movie")
    private int userRatingForMovie;

    @Column(name = "user_name")
    private String username;

    @Column (name = "review_rating")
    private int reviewRating;

    @Column (name = "rates_sum")
    private int ratesSum;

    @Column (name = "rates_amount")
    private int ratesAmount;

   @ElementCollection
   @CollectionTable(name = "comment", joinColumns = @JoinColumn(name="reviewid", nullable = false))
    private List<Comment> comments;


    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String reviewText, int userRatingForMovie,
                  String movieID, String userName, int ratesSum, int ratesAmount, List<Comment>comments) {

        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.userRatingForMovie = userRatingForMovie;
        this.username = userName;
        this.ratesAmount = ratesAmount;
        this.ratesSum = ratesSum;
        this.comments = comments;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}