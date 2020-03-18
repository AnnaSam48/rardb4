package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/reviews") //relative link to reviews
    public String reviewIndex(Model model) {

        Iterable<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);

        return "reviews-index";//view name
    }
//
//    @GetMapping("/add-review-search/add-review-movie/{id}(id=${movie.imdbID}/reviews/add")
//    public String addReviewPage(@PathVariable String id, Model model) {
//        model.addAttribute("review", new Review());
//        return "add-review";
//    }
//
//    @PostMapping("/add-review-search/add-review-movie/{id}(id=${movie.imdbID}/reviews/add-review")
//    public String addReview(@Valid Review reviewToAdd, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//
//            return "add-review";
//        }
//        reviewRepository.save(reviewToAdd);
//        return "redirect:/reviews";
//    }
}