package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.CommentRepository;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class indexController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/")
    public String toBestRatedReviews(Model model) {

        List<Review> matchedReviews = reviewRepository.findTop5ByOrderByReviewRatingDesc();
       /* //Load movies by ID from DB
        Set<String> movieIDS = new HashSet<>();
        for (Review matchedReview : matchedReviews) {
            movieIDS.add(matchedReview.getMovieID());
        }
        Iterable<Movie> matchedMovies = movieRepository.findAllById(movieIDS);

        // Make Map<> of them, where Key is imdbId and value the movie
        // so we can get them quickly later
        Map<String, Movie> movieMap = new HashMap<>();
        for (Movie matchedMovie : matchedMovies) {
            movieMap.put(matchedMovie.getImdbID(), matchedMovie);
        }

        // Create collection from ReadyReview, with values from Movie and from Review classes
        List<ReadyReview> readyReviews = new ArrayList<>();

        for (Review matchedReview : matchedReviews) {
            Movie movie = movieMap.get(matchedReview.getMovieID());

            ReadyReview readyReview = new ReadyReview(
                    movie.getImdbID(), matchedReview.getReviewID(), matchedReview.getReviewRating(),
                    matchedReview.getReviewTitle(), movie.getTitle(),
                    movie.getPoster(), matchedReview.getReviewText(),
                    matchedReview.getUserRatingForMovie(), matchedReview.getUserName()
            );

            readyReviews.add(readyReview);
        }
*/
        model.addAttribute("reviews", matchedReviews);
        return "index";
    }

}
