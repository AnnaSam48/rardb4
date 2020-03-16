package lv.accenture.bootcamp.rardb4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;
    private String reviewText;
    private String movieID;


    public Review(Long reviewID, String reviewText, String movieID) {
        this.reviewID = reviewID;
        this.reviewText = reviewText;
        this.movieID = movieID;
    }

    public Review() {
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
}
