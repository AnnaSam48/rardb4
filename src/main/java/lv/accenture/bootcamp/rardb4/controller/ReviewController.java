package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public String reviewIndex(Model model) {

        Iterable<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews-index";
    }

    @GetMapping("/reviews/highest-rated-reviews")
    public String highestReviews(@RequestParam double reviewRating, Model model) {
        List<Review> highestRatedReviews = reviewRepository.findByReviewRating(reviewRating);
        model.addAttribute("reviews", highestRatedReviews);
        return "reviews-index";
    }


    @PostMapping("/review/add")
    public String addAReview(Model model) {
        model.addAttribute("review", new Review());
        return "add-review";
    }
}
