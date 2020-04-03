package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class OtherUsersReviewController {

    @Autowired
    private ReviewRepository reviewRepository;



    @GetMapping("/reviews/profile/profile-reviews/{username}")
    public String showAllReviews(@PathVariable String username, Model model) {


        List<Review> reviewsByUser = reviewRepository.findAllByUsername(username);
        for(Review reviewByUser:reviewsByUser) {
            reviewRepository.save(reviewByUser);
        }
        model.addAttribute("reviews", reviewsByUser);

        return "profile/profile-reviews";
    }

}
