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
    private String text;
    private String movieID;


    public Review(Long reviewID, String text, String movieID) {
        this.reviewID = reviewID;
        this.text = text;
        this.movieID = movieID;
    }

    public Review() {
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
}
