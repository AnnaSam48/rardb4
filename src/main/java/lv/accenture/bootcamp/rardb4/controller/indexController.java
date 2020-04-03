package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.*;

@Controller
public class indexController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/")
    public String toBestRatedReviews(Model model) {

        List<Review> bestReviews = reviewRepository.findTop5ByOrderByReviewRatingDesc();
        model.addAttribute("reviews", bestReviews);
        return "index";
    }


    @GetMapping("/movies")
    public String bestMovies(Model model) {

        //Create a list with top 15 Movies
        List<Review> allMovies = reviewRepository.findAllByOrderByUserRatingForMovieDesc();
        model.addAttribute("reviews", allMovies);
        return "index";
    }


    @GetMapping("/moreReviews")
    public String getMoreReviews(Model model) {

        List<Review> bestReviews = reviewRepository.findAllByOrderByReviewRatingDesc();
        model.addAttribute("reviews", bestReviews);

        return "index";

    }

    @GetMapping("/header")
    public String getHeader() {
        return "header.html";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "footer.html";
    }
}


