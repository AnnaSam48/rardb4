package lv.accenture.bootcamp.rardb4.controller;

import com.sun.istack.Nullable;
import lv.accenture.bootcamp.rardb4.model.Comment;
import lv.accenture.bootcamp.rardb4.model.Rating;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.*;
import lv.accenture.bootcamp.rardb4.service.UserService;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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


    @GetMapping("/reviews-search/rate-review/{id}")
    public String editRatingPage(@PathVariable Long id, Model model) {
        //Getting data from rating page
        Optional<Review> reviewToBeRated = reviewRepository.findById(id);
        List<Comment> allComments = commentRepository.findAllByReviewID(id);

        model.addAttribute("comments", allComments);
        model.addAttribute("review", reviewToBeRated.get());
        model.addAttribute("commentOb", new Comment());
        return "rate-review";
    }


    @PostMapping("/reviews-search/rate-review/{id}") //all the data from here
    public String saveRatings(@PathVariable Long id, @Valid Review reviewToBeRated, BindingResult bindingResult) {

        //Getting the voter's username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        String userRatingReview = user.getUserName();

        //Getting new Rating object
        Rating newRating = new Rating();
        int newRatingValue;

        //Getting list of all the ratings for review
        List<Rating> matchedRatings = ratingRepository.findAllByReviewId(reviewToBeRated.getReviewID());

        //Making a list of all users that have rated this review already
        List<String> foundUsernames = new ArrayList<>();
        for (Rating matchedRating : matchedRatings) {
            foundUsernames.add(matchedRating.getRatedByUser());
        }

        //checking if voter is also the author of review
        try {
            if (reviewToBeRated.getUsername().equals(userRatingReview)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Sorry, you can't rate your own review!");
            return "rate-review";
        }

        //checking if voter has already rated review before
        try {
            for (String foundUsername : foundUsernames) {
                if (foundUsername.equals(userRatingReview)) {
                    throw new IllegalArgumentException();
                }
            }

        } catch (IllegalArgumentException ee) {
            System.out.println("Sorry, you can only vote once!");
            return "rate-review";
        }
        if (bindingResult.hasErrors()) {
            return "rate-review";

        } else {

            //getting the new rating value
            newRatingValue = reviewToBeRated.getRatingValue();

            //setting the new rating value in review and rating classes

            newRating.setReviewId(id);
            newRating.setValue(newRatingValue);
            newRating.setRatedByUser(userRatingReview);
            ratingRepository.save(newRating);

            reviewToBeRated.setReviewID(id);
            reviewToBeRated.setReviewRating(ratingRepository.average());
            reviewRepository.save(reviewToBeRated);

            return "redirect:/";
        }
    }
}
