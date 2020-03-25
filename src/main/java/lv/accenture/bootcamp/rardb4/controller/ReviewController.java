package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Comment;
import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.*;

@Controller
public class ReviewController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/reviews-search/rate-review/{id}")
    public String editReviewPage(@PathVariable Long id, Model model) {
        Optional<Review> reviewEdit = reviewRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByReviewID(id);

        model.addAttribute("comments", allComments);
        model.addAttribute("review", reviewEdit.get());
        model.addAttribute("commentOb", new Comment());
        return "rate-review";
    }


    @PostMapping("/reviews-search/rate-review/{id}") //where we are getting data from
    public String saveEdits(@PathVariable Long id, @Valid Review reviewRated, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rate-review";
        } else {
            Optional<Review> reviewOld = reviewRepository.findById(id);
            int newRatesSum = (reviewOld.get().getRatesSum() + reviewRated.getReviewRating());

            int newRatesAmount = reviewOld.get().getRatesAmount() + 1;
            int rating = newRatesSum / newRatesAmount;

            reviewRated.setReviewRating(rating);
            reviewRated.setRatesAmount(newRatesAmount);
            reviewRated.setRatesSum(newRatesSum);
            reviewRated.setReviewID(id);
            reviewRepository.save(reviewRated);

            return "redirect:/";
        }
    }


    @GetMapping("/reviews/delete-review/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews";
    }


    @GetMapping("/reviews-search")
    public String searchReviewsByMovieTitle(@RequestParam String movieTitle, Model model) {
        List<Review> matchedReviews = reviewRepository.findByMovieTitle(movieTitle);

        //Load movies by ID from DB
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


        model.addAttribute("reviews", readyReviews);
        return "reviews-on-movie";
    }

}
