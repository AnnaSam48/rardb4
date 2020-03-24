package lv.accenture.bootcamp.rardb4.controller;

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
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepositoryOld userRepositoryOld;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/")
    public String toBestRatedReviews(Model model) {

        List<Review> bestReviews = reviewRepository.findTop5ByOrderByReviewRatingDesc();

//        Load top5 reviews from DB and get their ID
//        Set<Long> reviewIDS = new HashSet<>();
//        for (Review bestReview : bestReviews) {
//            reviewIDS.add(bestReview.getReviewID());
//        }
//
//        Iterable<Review> matchedReviews = reviewRepository.findAllById(reviewIDS);
//
//        List<String> matchedMovieID = new ArrayList<>();
//        for (Review matchedReview : matchedReviews) {
//            String movieID = matchedReview.getMovieID();
//            matchedMovieID.add(movieID);
//        }
//
//        List<String> movieTitles = new ArrayList<>();
//        for (String movieID : matchedMovieID) {
//            String movieTitle = reviewRepository.movieTitleFromId(movieID);
//            movieTitles.add(movieTitle);
//        }
//
//        String movieTitle="";
//        for (String m : movieTitles){
//            movieTitle = m;
//            Movie movie = new Movie();
//            movie.setTitle(movieTitle);
//        }


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



