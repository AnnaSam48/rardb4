package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Comment;
import lv.accenture.bootcamp.rardb4.model.Rating;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.*;
import lv.accenture.bootcamp.rardb4.service.UserService;
import lv.accenture.bootcamp.rardb4.service.UserWithId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private CommentRepository commentRepository;



    @Autowired
    private ReviewRepository reviewRepository;



    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/reviews/reviews-search/rate-review/{id}")
    public String editRatingPage(@PathVariable Long id, Model model) {
        //Getting data from rating page
        Optional<Review> reviewToBeRated = reviewRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByReviewID(id);

        model.addAttribute("comments", allComments);
        model.addAttribute("review", reviewToBeRated.get());
        model.addAttribute("commentOb", new Comment());
        model.addAttribute("rating", new Rating());

        return "rate-review";
    }


    @PostMapping("/reviews/reviews-search/rate-review/{id}") //all the data from here
    public String saveRatings(@PathVariable Long id, @Valid Rating ratingToEdit, BindingResult bindingResult) {

        //Getting the voter's userID
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserWithId userWithId = (UserWithId) auth.getPrincipal();
        Long userRatingReview = userWithId.getUserId();


        //Getting new Rating object
        Rating newRating = new Rating();
        int newRatingValue;

        //Getting list of all the ratings for review
        List<Rating> matchedRatings = ratingRepository.findAllByReviewId(id);

        //Making a list of all users that have rated this review already
        List<Long> foundUserIDS = new ArrayList<>();
        for (Rating matchedRating : matchedRatings) {
            foundUserIDS.add(matchedRating.getRatedByUserId());
        }

        //checking if voter is also the author of review
        try {
            if (reviewRepository.findByReviewID(id).get().getUserId() == (userRatingReview)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return "rating-submit-error";
        }

        //checking if voter has already rated review before
        try {
            for (Long foundUserID : foundUserIDS) {
                if (foundUserID == (userRatingReview)) {
                    throw new IllegalArgumentException();
                }
            }

        } catch (IllegalArgumentException ee) {
            return "rating-submit-error";
        }
        if (bindingResult.hasErrors()) {
            return "rating-submit-error";

        } else {

            //getting the new rating value
            newRatingValue = ratingToEdit.getValue();
            //setting the new rating value in review and rating classes

            newRating.setReviewId(id);
            newRating.setValue(newRatingValue);
            newRating.setRatedByUserId(userRatingReview);
            ratingRepository.save(newRating);


            Review reviewToAddRating = reviewRepository.findByReviewID(id).get();
            reviewToAddRating.setReviewID(id);
            reviewToAddRating.setReviewRating(ratingRepository.average(id));
            reviewRepository.save(reviewToAddRating);

            return "redirect:/";
        }
    }

    @GetMapping("/reviews/rating-submitting-error")
    public String submitError() {
        return "rating-submit-error";
    }
}

/*
trying to show if the reviiew has already been rated under review text
    @GetMapping("/reviews/reviews-search/rate-review/{id}")
    public String editRatingPage(@PathVariable Long id, Model model) {

        //Getting  data from rating page
        //Review and Comments
        Optional<Review> reviewToBeRated = reviewRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByReviewID(id);

        //user data
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.isAuthenticated()) {
            reviewToBeRated.get().setAlreadyRatedThisReview("");

        }else{
            UserWithId userWithId = (UserWithId) auth.getPrincipal();
            Long userRatingReview = userWithId.getUserId();

            List<Rating> matchedRatings = ratingRepository.findAllByReviewId(id);
            //Making a list of all users that have rated this review already
            List<Long> foundUserIDS = new ArrayList<>();
            for (Rating matchedRating : matchedRatings) {
                foundUserIDS.add(matchedRating.getRatedByUserId());
            }
            for (Long foundUserID : foundUserIDS) {
                if (foundUserID == (userRatingReview)) {
                    reviewToBeRated.get().setAlreadyRatedThisReview("You have already rated this review.");
                }
            }
        }


        model.addAttribute("comments", allComments);
        model.addAttribute("review", reviewToBeRated.get());
        model.addAttribute("commentOb", new Comment());
        model.addAttribute("rating", new Rating());

        return "rate-review";
    }


    @PostMapping("/reviews/reviews-search/rate-review/{id}") //all the data from here
    public String saveRatings(@PathVariable Long id, @Valid Rating ratingToEdit, BindingResult bindingResult) {

        //Getting the voter's userID
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserWithId userWithId = (UserWithId) auth.getPrincipal();
        Long userRatingReview = userWithId.getUserId();

        //Getting new Rating object
        Rating newRating = new Rating();
        int newRatingValue;

        //checking if voter is also the author of review
        try {
            if (reviewRepository.findByReviewID(id).get().getUserId() == (userRatingReview)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return "rating-submit-error";
        }

        //checking if voter has already rated review before
        try {

            if (!reviewRepository.findByReviewID(id).get().getAlreadyRatedThisReview().equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ee) {
            return "rating-submit-error";
        }
        if (bindingResult.hasErrors()) {
            return "rating-submit-error";

        } else {

            //getting the new rating value
            newRatingValue = ratingToEdit.getValue();
            //setting the new rating value in review and rating classes

            newRating.setReviewId(id);
            newRating.setValue(newRatingValue);
            newRating.setRatedByUserId(userRatingReview);
            ratingRepository.save(newRating);


            Review reviewToAddRating = reviewRepository.findByReviewID(id).get();
            reviewToAddRating.setReviewID(id);
            reviewToAddRating.setReviewRating(ratingRepository.average(id));
            reviewRepository.save(reviewToAddRating);

            return "redirect:/";
        }
    }
*/


