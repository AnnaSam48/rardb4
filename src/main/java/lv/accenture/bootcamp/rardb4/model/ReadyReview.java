package lv.accenture.bootcamp.rardb4.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ReadyReview implements Serializable {

    private double reviewRating;
    private String reviewTitle;
    private String Title;
    private String Poster;
    private String reviewText;
    private double userRatingForMovie;

    public ReadyReview(double reviewRating, String reviewTitle, String title,
                       String poster, String reviewText, double userRatingForMovie) {
        this.reviewRating = reviewRating;
        this.reviewTitle = reviewTitle;
        Title = title;
        Poster = poster;
        this.reviewText = reviewText;
        this.userRatingForMovie = userRatingForMovie;
    }
}
