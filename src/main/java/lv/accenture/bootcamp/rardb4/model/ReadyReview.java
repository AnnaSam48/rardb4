package lv.accenture.bootcamp.rardb4.model;

import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class ReadyReview implements Serializable {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Movie movie;

    @Autowired
    Review review;

    @Autowired
    User user;

    private String imdbID;
    private double reviewRating;
    private String reviewTitle;
    private String Title;
    private String Poster;
    private String reviewText;
    private double userRatingForMovie;
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
        return movie.getImdbID();
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public double getReviewRating() { return review.getReviewRating(); }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getReviewTitle() {
        return review.getReviewTitle();
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getTitle() {
        return reviewRepository.movieTitleFromId(imdbID);
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPoster() {
        return reviewRepository.posterURL(imdbID);
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getReviewText() {
        return review.getReviewText();
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getUserRatingForMovie() {
        return review.getUserRatingForMovie();
    }

    public void setUserRatingForMovie(double userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public String getUserName() {
        return user.getUsername();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
