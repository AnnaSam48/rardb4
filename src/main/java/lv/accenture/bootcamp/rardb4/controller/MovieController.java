package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.MovieAPI.MovieAPIService;
import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Rating;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.model.User;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.RatingRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import lv.accenture.bootcamp.rardb4.model.Rating;
//import lv.accenture.bootcamp.rardb4.repository.RatingRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class MovieController {

    @Autowired
    private MovieAPIService movieAPIService;

    @Autowired
    private MovieRepository moviesRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/add-review-search")
    public String addReviewSearchPage() {

        return "add-review-search";
    }


    @GetMapping("/add-review-search/search")
    public String searchMoviesByKeyword(Model model, @RequestParam String keyword) {
        List<Movie> foundMovies = movieAPIService.getMovie(keyword);
        model.addAttribute("movies", foundMovies);
        return "add-review-search"; //if we do redirect then we loose parameter
    }

    @GetMapping("/add-review-search/add-review-movie/{id}")
    public String viewAndAddReviewPage(@PathVariable String id, Model model) { //this id is the same id in URL
        Movie movieToShow = movieAPIService.getMovieByID(id);
        model.addAttribute("movie", movieToShow); //with what data we are working with
        model.addAttribute("review", new Review());
        return "add-review-movie";
    }

    @PostMapping(value = "/add-review-search/add-review-movie/{id}")
    //Model and view for notification that submitted pops up at same page
    public ModelAndView addReview(@PathVariable String id, @Valid Review reviewToAdd, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add-review-search");
        } else {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserWithId userWithId = (UserWithId) auth.getPrincipal();
            String username = userWithId.getUsername();
            Long userId = userWithId.getUserId();

            if (!moviesRepository.existsById(id)) {
                Movie movieToAdd = movieAPIService.getMovieByID(id);
                moviesRepository.save(movieToAdd);
                reviewToAdd.setUsername(username);
                reviewToAdd.setMoviePicture(movieAPIService.getMovieByID(id).getPoster());
                reviewToAdd.setMovieTitle(movieAPIService.getMovieByID(id).getTitle());
                reviewToAdd.setUserId(userId);
                reviewToAdd.setMovieID(id);

                reviewRepository.save(reviewToAdd);

                Movie movieToShow = movieAPIService.getMovieByID(id);

                modelAndView.addObject("movie", movieToShow);
                modelAndView.setViewName("movie-added");
            }else {


                try {
                    List<Review> existingReviews = reviewRepository.findAllByMovieID(id);

                    for (Review existingReview : existingReviews) {
                        if (existingReview.getUserId() == userId) {
                            throw new IllegalArgumentException();
                        } else {

                            Movie movie = moviesRepository.findByImdbID(id);
                            reviewToAdd.setUsername(username);
                            reviewToAdd.setMoviePicture(movie.getPoster());
                            reviewToAdd.setMovieTitle(movie.getTitle());
                            reviewToAdd.setUserId(userId);
                            reviewToAdd.setMovieID(id);

                            modelAndView.setViewName("movie-added");
                        }
                    }
                    reviewRepository.save(reviewToAdd);


                } catch (IllegalArgumentException e) {
                    modelAndView.setViewName("same-movie-error");

                }}
        }

        //modelAndView.addObject("review", new Review());
        return modelAndView;
    }

    @GetMapping("/add-review-movie/reviewSubmitted")
    public String resultSubmitted() {
        return "movie-added.html";
    }

    @GetMapping("/reviews/about-movie/{id}")
    public String aboutMovie(@PathVariable String id, Model model) { //this id is the same id in URL
        Optional<Movie> movieToShow = moviesRepository.findById(id);

        List<Review> reviewsByMovie = reviewRepository.findAllByMovieID(id);
        model.addAttribute("reviews", reviewsByMovie);
        model.addAttribute("movie", movieToShow.get()); //with what data we are working with
        return "about-movie";
    }

}