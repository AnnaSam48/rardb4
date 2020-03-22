package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.*;
import lv.accenture.bootcamp.rardb4.repository.CommentRepository;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class CommentController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/reviews-search/rate-review/{id}/comments")
    public String allCommentsByReviewId(@RequestParam Long reviewID, Model model) {
        List<Comment> matchedComments = commentRepository.findByReviewId(reviewID);

        //Load reviews by ID from DB
        Set<Long> reviewIDS = new HashSet<>();
        for (Comment matchedComment : matchedComments) {
            reviewIDS.add(matchedComment.getReviewID());
        }

        Iterable<Review> matchedReviews = reviewRepository.findAllById(reviewIDS);

        // Make Map<> of them, where Key is imdbId and value the movie
        // so we can get them quickly later
        Map<Long, Review> reviewMap = new HashMap<>();
        for (Review matchedReview : matchedReviews) {
            reviewMap.put(matchedReview.getReviewID(), matchedReview);
        }

        // Create collection from Comment, with values from Review and Comment classes
        List<FullCommentInfo> fullComments = new ArrayList<>();

        for (Comment matchedComment : matchedComments) {
            Review review = reviewMap.get(matchedComment.getReviewID());

            FullCommentInfo fullCommentInfo =new FullCommentInfo(
                    review.getReviewID(), review.getReviewRating(), review.getReviewTitle(),
                    review.getReviewText(), review.getUserRatingForMovie(), review.getUserName(),
                    matchedComment.getCommentID(), matchedComment.getCommentText(),
                    matchedComment.getCommentUsername(),matchedComment.getTimestamp()
            );
            fullComments.add(fullCommentInfo);
        }

        model.addAttribute("comments", fullComments);
        return "rate-review";
    }
}



