package lv.accenture.bootcamp.rardb4.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
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

    private String userName;

    private double reviewRating;

    private String comment;


    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String reviewText, String movieID, String userName, String comment) {

        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.movieID = movieID;
        this.userName = userName;
        this.comment = comment;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
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

    public void setReviewRating(double reviewRating) { this.reviewRating = reviewRating; }

}
