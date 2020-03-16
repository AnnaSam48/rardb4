package lv.accenture.bootcamp.rardb4.controller;

import lv.accenture.bootcamp.rardb4.MovieAPI.MovieAPIService;
import lv.accenture.bootcamp.rardb4.model.Movie;
import lv.accenture.bootcamp.rardb4.model.Review;
import lv.accenture.bootcamp.rardb4.repository.MovieRepository;
import lv.accenture.bootcamp.rardb4.repository.ReviewRepository;
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
public class MovieController {

    @Autowired
    private MovieAPIService movieAPIService;

    @Autowired
    private MovieRepository moviesRepository;

    @Autowired
    private ReviewRepository reviewRepository;



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
        return "add-review-movie";
    }

    /*@PostMapping("/add-review-search/add-review-movie/{id}")
    public String addCat(@PathVariable String id, @Valid Review reviewToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add-review-search/add-review-movie";
        }else {
            reviewToAdd.setMovieID(id);
            reviewRepository.save(reviewToAdd); //adding to the model
            return "redirect:/add-review-search";
        }
    }*/


}
