package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserReviewsController {


    @Autowired
    ReviewRepository reviewRepository;


    @Autowired
    private UserService userService;


    @GetMapping("/user/home/reviews")
    public String userReviews(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        String username = user.getUserName();
        List<Review> allReviews = reviewRepository.findAllByUsername(username);
        model.addAttribute("reviews", allReviews);

        return "user/userReviews";
    }

    @GetMapping("/user/home/reviews-search/edit-review/{id}")
    public String editUserReviews(@PathVariable Long id, Model model) {
        Optional<Review> reviewToEdit = reviewRepository.findByReviewID(id);
        model.addAttribute("review", reviewToEdit.get());
        return "user/edit-review";
    }
    //

    @PostMapping("/user/home/reviews-search/edit-review/{id}") //edit Review is working
    public String editReview(@PathVariable Long id, @Valid Review editedReview, BindingResult bindResult) {

        Review oldReview = reviewRepository.findById(id).get(); //getting an old Review to get all additional values from it (which we don't have in the html form)

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        String username = user.getUserName();
        Long userId = user.getId();

        editedReview.setReviewID(id);
        editedReview.setMovieID(oldReview.getMovieID());
        editedReview.setUsername(username);
        editedReview.setMoviePicture(oldReview.getMoviePicture());
        editedReview.setMovieTitle(oldReview.getMovieTitle());
        editedReview.setUsername(oldReview.getUsername());
        editedReview.setUserId(userId);


        if (bindResult.hasErrors()) {
            return "user/edit-review";
        }
        reviewRepository.save(editedReview);
        return "redirect:/user/home/reviews";
    }

    @GetMapping("/user/delete-review/{id}")
    public String deleteReview(@PathVariable Long id, Model model) {
        Optional<Review> reviewToDelete = reviewRepository.findByReviewID(id);
        model.addAttribute("review", reviewToDelete.get());
        reviewRepository.deleteById(id);
        return "redirect:/user/home/reviews";
    }


}