package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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


    @PostMapping("/review/add-review")
    public String addAReview(@Valid Review reviewToAdd, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-review";
        }
        model.addAttribute("review", new Review());
        return "reviews-index";
    }

    @GetMapping("/reviews/edit/{reviewID}")
    public String editReview(@PathVariable Long reviewID, Model model) {
        Optional<Review> reviewToEdit = reviewRepository.findById(reviewID);
        model.addAttribute("review", reviewToEdit.get());
        return "edit-review";
    }

    @PostMapping("/reviews/edit-review/{reviewID}")
    public String editedReview(@PathVariable Long reviewID, @Valid Review editedReview, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-review";
        }
        editedReview.setReviewID(reviewID);
        reviewRepository.save(editedReview);
        return "redirect:/reviews";
    }

    @GetMapping("/reviews/delete-review/{reviewID}")
    public String deleteReview(@PathVariable Long reviewID) {
        reviewRepository.deleteById(reviewID);
        return "redirect:/reviews";
    }
}
