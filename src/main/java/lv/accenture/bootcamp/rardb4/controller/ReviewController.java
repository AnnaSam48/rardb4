package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/review/add")
    public String addAReview(Model model) {
        model.addAttribute("review", new Review());
        return "add-review";
    }
}
