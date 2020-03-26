package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.ReadyReview;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
import lv.accenture.bootcamp.rardb4.repository.UserRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/home")
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage", "Content Available Only for Users");
        modelAndView.setViewName("user/home");
        return modelAndView;
    }

    @GetMapping("/user/home/profile")
    public ModelAndView userHomeProfile() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("profilePic", user.getProfileIconURL());
        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("nameUser", user.getName());
        modelAndView.addObject("last", user.getLastName());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("userMessage", "Content Available Only for Users");
        modelAndView.setViewName("user/userProfile");
        return modelAndView;
    }

    @GetMapping("/user/home/reviews")
    public String userReviews(Model model) {
        //ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        String username = user.getUserName();

        List<Review> allReviews = reviewRepository.findAllByUsername(username);

        model.addAttribute("reviews", allReviews);

        return "user/userReviews";
    }

  /*KRISTA  @GetMapping("/user/reviews-search")
    public String searchReviewsByMovieTitle(@RequestParam String movieTitle, Model model) {
        List<Review> matchedReviews = reviewRepository.findByMovieTitle(movieTitle);
        //Load movies by ID from DB
        Set<String> movieIDS = new HashSet<>();
        for (Review matchedReview : matchedReviews) {
            movieIDS.add(matchedReview.getMovieID());
        }
        Iterable<Movie> matchedMovies = movieRepository.findAllById(movieIDS);
        // Make Map<> of them, where Key is imdbId and value the movie
        // so we can get them quickly later
        Map<String, Movie> movieMap = new HashMap<>();
        for (Movie matchedMovie : matchedMovies) {
            movieMap.put(matchedMovie.getImdbID(), matchedMovie);
        }
        // Create collection from ReadyReview, with values from Movie and from Review classes
        List<ReadyReview> readyReviews = new ArrayList<>();
        for (Review matchedReview : matchedReviews) {
            Movie movie = movieMap.get(matchedReview.getMovieID());
            ReadyReview readyReview = new ReadyReview(
                    movie.getImdbID(), matchedReview.getReviewID(), matchedReview.getReviewRating(),
                    matchedReview.getReviewTitle(), movie.getTitle(),
                    movie.getPoster(), matchedReview.getReviewText(),
                    matchedReview.getUserRatingForMovie(), matchedReview.getUserName()
            );
            readyReviews.add(readyReview);
        }
        model.addAttribute("reviews", readyReviews);
        return "reviews-on-movie";
    }
*/

}