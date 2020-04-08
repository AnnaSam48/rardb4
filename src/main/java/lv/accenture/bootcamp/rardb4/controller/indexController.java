package lv.accenture.bootcamp.rardb4.controller;


import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class indexController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/")
    public String toBestRatedReviews(Model model) {
        //Create a line with top 15 Movies
        List<Review> allMovies = reviewRepository.findTop10ByOrderByUserRatingForMovieDesc();
        model.addAttribute("allMovies", allMovies);

        //Create table with best reviews
        List<Review> bestReviews = reviewRepository.findTop5ByOrderByReviewRatingDesc();
        model.addAttribute("reviews", bestReviews);
        return "index";
    }


    @GetMapping("/reviews/movies")
    public String bestMovies(Model model) {

        //Create a table with all movies by user rating
        List<Review> allMovies = reviewRepository.findAllByOrderByUserRatingForMovieDesc();
        model.addAttribute("movies", allMovies);
        return "movie";
    }


    @GetMapping("/reviews/moreReviews")
    public String getMoreReviews(Model model) {
        //Create a table with all reviews
        List<Review> bestReviews = reviewRepository.findAllByOrderByReviewRatingDesc();
        model.addAttribute("reviews", bestReviews);
        return "index";
    }

    //header and footer
    @GetMapping("/header")
    public String getHeader() {
        return "header.html";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "footer.html";
    }

}


