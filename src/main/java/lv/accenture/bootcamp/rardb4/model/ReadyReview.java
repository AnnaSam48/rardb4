//package lv.accenture.bootcamp.rardb4.model;
//
//import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
//import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
//import lv.accenture.bootcamp.rardb4.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.Entity;
//import java.io.Serializable;
//
//@Entity
//public class ReadyReview implements Serializable {
//
//    @Autowired
//    MovieRepository movieRepository;
//
//    @Autowired
//    ReviewRepository reviewRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    Movie movie;
//
//    @Autowired
//    Review review;
//
//    User user =new User();
//
//    private String imdbID;
//
//
//    private double reviewRating;
//    private String reviewTitle;
//    private String Title;
//    private String Poster;
//    private String reviewText;
//    private double userRatingForMovie;
//
//    public ReadyReview(String imdbID, double reviewRating, String reviewTitle, String title,
//                       String poster, String reviewText, double userRatingForMovie) {
//
//        this.imdbID = imdbID;
//        this.reviewRating = reviewRating;
//        this.reviewTitle = reviewTitle;
//        Title = title;
//        Poster = poster;
//        this.reviewText = reviewText;
//        this.userRatingForMovie = userRatingForMovie;
//    }
//
//
//    public String getImdbID() {
//        return imdbID;
//    }
//
//    public void setImdbID(String imdbID) {
//        this.imdbID = imdbID;
//    }
//
//    public double getReviewRating() {
//        return reviewRating = review.getReviewRating();
//    }
//
//    public void setReviewRating(double reviewRating) {
//        this.reviewRating = reviewRating;
//    }
//
//    public String getReviewTitle() {
//        return reviewTitle;
//    }
//
//    public void setReviewTitle(String reviewTitle) {
//        this.reviewTitle = reviewTitle;
//    }
//
//    public String getTitle() {
//        return Title= reviewRepository.movieTitleFromId(imdbID);
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
//
//    public String getReviewText() {
//        return reviewText;
//    }
//
//    public void setReviewText(String reviewText) {
//        this.reviewText = reviewText;
//    }
//
//    public double getUserRatingForMovie() {
//        return userRatingForMovie;
//    }
//
//    public void setUserRatingForMovie(double userRatingForMovie) {
//        this.userRatingForMovie = userRatingForMovie;
//    }
//}
