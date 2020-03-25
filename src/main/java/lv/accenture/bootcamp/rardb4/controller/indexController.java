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
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;


    @GetMapping("/")
    public String toBestRatedReviews(Model model) {

        List<Review> bestReviews = reviewRepository.findTop5ByOrderByReviewRatingDesc();

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


