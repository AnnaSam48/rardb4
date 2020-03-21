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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        return "/reviews-on-movie-index";//all reviews are here
    }


    @GetMapping("/reviews-search/rate-review/{id}")
    public String rateReview(@PathVariable Long id, Model model) { //this id is the same id in URL
        Optional<Review> reviewToRate = reviewRepository.findById(id);
        model.addAttribute("review", reviewToRate.get()); //with what data we are working with
        return "rate-review";
    }

    @PostMapping("/reviews-search/rate-review/{id}") //where we are getting data from
    public String saveEdits(@PathVariable Long id, @Valid Review reviewRated, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "rate-review";
        }else {
            reviewRated.setReviewID(id);
            reviewRepository.save(reviewRated);
            return "redirect:/";
        }
    }

//
//    @GetMapping("/reviews/edit/{id}")
//    public String editReviewPage(@PathVariable Long id, Model model) {
//        Optional<Review> reviewToEdit = reviewRepository.findById(id);
//        model.addAttribute("review", reviewToEdit.get());
//        return "edit-review";
//    }
//
//    @PostMapping("/reviews/edit-review/{id}")
//    public String editCat(@PathVariable Long id, @Valid Review editedReview, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "edit-review";
//        }
//        editedReview.setId(id);
//        reviewRepository.save(editedReview);
//        return "redirect:/cats";
//    }

    @GetMapping("/reviews/delete-review/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews";
    }


    @GetMapping("/reviews-search")
    public String searchReviewsByMovieTitle(@RequestParam String movieTitle, Model model) {
        List<Review> matchedReviews = reviewRepository.findByMovieTitle(movieTitle);
        model.addAttribute("reviews", matchedReviews);
        return "reviews-on-movie";
    }


}