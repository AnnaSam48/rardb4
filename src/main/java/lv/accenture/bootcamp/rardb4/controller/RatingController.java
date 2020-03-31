package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Comment;
import lv.accenture.bootcamp.rardb4.model.Rating;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.*;
import lv.accenture.bootcamp.rardb4.service.UserService;
import lv.accenture.bootcamp.rardb4.service.UserWithId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.util.*;

@Controller
public class RatingController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/reviews-search/rate-review/{reviewId}")
    public String editRatingPage(@PathVariable Long reviewId, Model model) {
        //Getting data from rating page
       // Optional<Review> reviewToBeRated = reviewRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByReviewID(reviewId);

        model.addAttribute("comments", allComments);
       // model.addAttribute("review", reviewToBeRated.get());
        model.addAttribute("commentOb", new Comment());
        return "rate-review";
    }


    @PostMapping("/reviews-search/rate-review/{reviewId}") //all the data from here
    public String saveRatings(@PathVariable Long reviewId, @Valid Rating ratingToEdit, BindingResult bindingResult) {

        //Getting the voter's userID
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserWithId userWithId = (UserWithId) auth.getPrincipal();
        Long userRatingReview = userWithId.getUserId();


        //Getting new Rating object
        Rating newRating = new Rating();
        int newRatingValue;

        //Getting list of all the ratings for review
        List<Rating> matchedRatings = ratingRepository.findAllByReviewId(reviewId);

        //Making a list of all users that have rated this review already
        List<Long> foundUserIDS = new ArrayList<>();
        for (Rating matchedRating : matchedRatings) {
            foundUserIDS.add(matchedRating.getRatedByUserId());
        }

        //checking if voter is also the author of review
        try {
            if (reviewRepository.findByReviewID(reviewId).get().getUserId()==(userRatingReview)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Sorry, you can't rate your own review!");
            return "rating-submit-error";
        }

        //checking if voter has already rated review before
        try {
            for (Long foundUserID : foundUserIDS) {
                if (foundUserID==(userRatingReview)) {
                    throw new IllegalArgumentException();
                }
            }

        } catch (IllegalArgumentException ee) {
            System.out.println("Sorry, you can only vote once!");
            return "rating-submit-error";
        }
        if (bindingResult.hasErrors()) {
            return "rating-submit-error";

        } else {

            //getting the new rating value
            newRatingValue = ratingToEdit.getValue();

            //setting the new rating value in review and rating classes

            newRating.setReviewId(reviewId);
            newRating.setValue(newRatingValue);
            newRating.setRatedByUserId(userRatingReview);
            ratingRepository.save(newRating);

            reviewRepository.findByReviewID(reviewId).get().setReviewID(reviewId);
            reviewRepository.findByReviewID(reviewId).get().setReviewRating(ratingRepository.average(reviewId));

            return "redirect:/";
        }
    }

    @GetMapping("/rating-submitting-error")
    public String submitError() {
        return "rating-submit-error";
    }
}
